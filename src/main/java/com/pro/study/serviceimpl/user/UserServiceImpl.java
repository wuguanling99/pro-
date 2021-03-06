package com.pro.study.serviceimpl.user;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lambdaworks.crypto.SCryptUtil;
import com.pro.study.dao.role.ProRoleRepository;
import com.pro.study.dao.user.UserMybatisDao;
import com.pro.study.dao.user.UserRepository;
import com.pro.study.dto.sys.LimitDto;
import com.pro.study.dto.user.CheckUserDTO;
import com.pro.study.dto.user.UserBaseInfoDTO;
import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.enums.SysRoleEnum;
import com.pro.study.po.role.ProRole;
import com.pro.study.po.user.User;
import com.pro.study.service.user.UserService;
import com.pro.study.utils.ETLUtil;
import com.pro.study.utils.IdCardUtil;
import com.pro.study.utils.JWTUtil;
import com.pro.study.utils.OSSClientUtil;
import com.pro.study.utils.ResponseUtils;
import com.pro.study.utils.UserUtils;
import com.pro.study.vo.request.sys.PageInfo;
import com.pro.study.vo.request.user.CheckUserReuqestDTO;
import com.pro.study.vo.request.user.CreateUserInfoVO;
import com.pro.study.vo.request.user.UserBaseInfoRequestVO;
import com.pro.study.vo.request.user.UserLoginVO;
import com.pro.study.vo.response.sys.ImageReponseVO;
import com.pro.study.vo.response.sys.Page;
import com.pro.study.vo.response.sys.SysResponseVO;
import com.pro.study.vo.response.user.CheckUserListReponseVO;
import com.pro.study.vo.response.user.LoanApplyTableUserBaseInfoVO;
import com.pro.study.vo.response.user.LoginResponseVO;
import com.pro.study.vo.response.user.LogoutResponseVO;
import com.pro.study.vo.response.user.UserBaseBaseInfoReponseVO;

/** 
* @author: wgl
* @date: 2020年2月26日下午11:06:54 
* @version:1.0
* @Description: 用户业务层
*/
@Service
public class UserServiceImpl implements UserService {
	
	@Value("${tokentime}")
	private Integer tokentime;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMybatisDao userDao;
	@Autowired
	private ProRoleRepository roleMapper;
	@Autowired
	private RedisTemplate redisTemplate;
	/**
	 * 登陆
	 * @throws Exception 
	 */
	@Override
	public LoginResponseVO login(UserLoginVO loginVo) throws Exception {
		String password = loginVo.getPassword();
		String username = loginVo.getUsername();
		//登陆验证
		User user = userRepository.findByUsername(username);
		String userPassword = SCryptUtil.scrypt(password, 32768, 8, 1);
		//校验账户名密码
		if(user != null && SCryptUtil.check(password, user.getPassword())) {
			LoginResponseVO loginResponseVO = new LoginResponseVO();
			loginResponseVO.setCode(SysDicEnum.SUCCESS.getCode());
			loginResponseVO.setName(user.getName());
			//查询用户对应的权限
			ProRole proRole = roleMapper.findById(user.getRoleId()).get();
			UserInfoDTO userInfoDTO = new UserInfoDTO();
			userInfoDTO.setName(user.getName());
			userInfoDTO.setRole(proRole.getRoleName());
			userInfoDTO.setUserId(user.getId());
			userInfoDTO.setRoleId(proRole.getId());
			userInfoDTO.setCompanyId(user.getCompanyId());
			String createJWT = JWTUtil.createJWT(userInfoDTO);
			String uuidTokenKey = UUID.randomUUID().toString();
			redisTemplate.opsForValue().set(uuidTokenKey, createJWT,tokentime,TimeUnit.SECONDS);
			loginResponseVO.setToken(uuidTokenKey);
			return loginResponseVO;
		}else {
			LoginResponseVO loginResponseVO = new LoginResponseVO();
			loginResponseVO.setCode(SysDicEnum.USERNAMEORPASSWORDERROR.getCode());
			return loginResponseVO;
		}
	}
	
	/**
	 * 创建申贷人
	 */
	@Override
	public SysResponseVO createLoanApplicant(CreateUserInfoVO userVO) {
		User user = new User();
		/**
		 * 先校验用户名是否存在
		 */
		User userByUserName = userRepository.findByUsername(userVO.getUsername());
		if(userByUserName!=null) {
			//证明已经存在的用户
			return ResponseUtils.createResponse(SysDicEnum.HAS_USER);
		}
		BeanUtils.copyProperties(userVO, user);
		//数据库保存加密后的密码
		//查询数据库获取申贷人角色id
		ProRole loanApply = roleMapper.findByRoleName(SysRoleEnum.LOAN_APPLY.getRole());
		user.setPassword(SCryptUtil.scrypt(user.getPassword(), 32768, 8, 1));
		user.setRoleId(loanApply.getId());
		try {
			userRepository.save(user);
		}catch (Exception e) {
			//保存的时候发生错误
			//返回系统异常
			return ResponseUtils.returnSysError();
		}
		return ResponseUtils.returnSuccess();
	}
	
	/**
	 * 登出
	 */
	@Override
	public LogoutResponseVO logout(String token) {
		try {
			redisTemplate.delete(token);
			return new LogoutResponseVO(SysDicEnum.SUCCESS.getCode(),"登出成功"); 
		}catch (Exception e) {
			return  new LogoutResponseVO(SysDicEnum.ERROR.getCode(),SysDicEnum.ERROR.getMessage());
		}
	}
	
	/**
	 * 获取用户基本信息
	 * @throws ParseException 
	 */
	@Override
	public LoanApplyTableUserBaseInfoVO getBaseUserInfo(HttpServletRequest request) throws ParseException {
		LoanApplyTableUserBaseInfoVO result = new LoanApplyTableUserBaseInfoVO();
		UserInfoDTO user = UserUtils.getUser(request);
		Long userId = user.getUserId();
		User userPo = userRepository.findById(userId).get();
		//过滤敏感信息
		result.setIdCard(ETLUtil.etlIdCard(userPo.getIdCard()));
		result.setName(userPo.getName());
		result.setEmail(userPo.getEmail());
		result.setPhoneNumber(ETLUtil.etlPhoneNumber(userPo.getPhoneNumber()));
		result.setAge(IdCardUtil.getAge(userPo.getIdCard()));
		result.setSexByEnum(IdCardUtil.getSex(userPo.getIdCard()));
		return result;
	}
	
	/**
	 * 获取用户基本信息
	 */
	@Override
	public UserBaseBaseInfoReponseVO getBaseUserInfo(UserInfoDTO user) {
		Long userId = user.getUserId();
		try {
			//获取用户基本信息
			UserBaseInfoDTO userBaseInfo = userDao.findUser(userId,SysDicEnum.SYS_VALID.getCode());
			UserBaseBaseInfoReponseVO result = new UserBaseBaseInfoReponseVO(SysDicEnum.SUCCESS.getCode(),"数据获取成功");
			result.setUserId(userBaseInfo.getId());
			result.setEmail(userBaseInfo.getEmail());
			OSSClientUtil ossClientUtil = new OSSClientUtil();
			String url = ossClientUtil.getHeadImageUrl(userBaseInfo.getHead_image());
			result.setHeadImage(url);
			result.setIdCard(ETLUtil.etlIdCard(userBaseInfo.getId_card()));
			result.setName(userBaseInfo.getName());
			result.setPhoneNumber(ETLUtil.etlPhoneNumber(userBaseInfo.getPhone_number()));
			return result; 
		}catch (Exception e) {
			return new UserBaseBaseInfoReponseVO(SysDicEnum.ERROR.getCode(),"用户信息获取失败");
		}
	}
	
	/**
	 * 修改用户基本信息
	 */
	@Override
	public UserBaseBaseInfoReponseVO updateBaseInfo(UserBaseInfoRequestVO userBaseInfo) {
		try {
			//判断是否修改了手机号
			String phoneNumber = userBaseInfo.getPhoneNumber();
			if(ETLUtil.isETLPhoneNumber(phoneNumber)) {
				//查询原来的手机号并赋值
				UserBaseInfoDTO user = userDao.findUser(userBaseInfo.getUserId(), SysDicEnum.SYS_VALID.getCode());
				userBaseInfo.setPhoneNumber(user.getPhone_number());
			}
			userDao.updateUserInfo(userBaseInfo);
			UserBaseBaseInfoReponseVO result = new UserBaseBaseInfoReponseVO(SysDicEnum.SUCCESS.getCode(),"信息修改成功");
			result.setUserId(userBaseInfo.getUserId());
			result.setEmail(userBaseInfo.getEmail());
			result.setHeadImage(userBaseInfo.getHeadImage());
			result.setPhoneNumber(ETLUtil.etlPhoneNumber(userBaseInfo.getPhoneNumber()));
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return new UserBaseBaseInfoReponseVO(SysDicEnum.ERROR.getCode(),"信息修改失败");
		}
	}
	
	/**
	 * 头像上传
	 */
	@Override
	public ImageReponseVO uploadUserHeadImage(UserInfoDTO userInfoDTO, MultipartFile file) {
		try {
			OSSClientUtil ossClientUtil = new OSSClientUtil();
			String key = ossClientUtil.uploadImgHeadImage(file,userInfoDTO.getUserId());
			String url = ossClientUtil.getHeadImageUrl(key);
			return new ImageReponseVO(SysDicEnum.SUCCESS.getCode(),"图片上传成功",url,key);
		}catch (Exception e) {
			return new ImageReponseVO(SysDicEnum.ERROR.getCode(),"图片上传失败");
		}
	}
	
	/**
	 * 获取审核员列表
	 */
	@Override
	public Page<CheckUserListReponseVO> getCheckUserList(UserInfoDTO user, PageInfo page) {
		try {
		LimitDto limit = Page.getLimit(page.getPageNum(), page.getPageSize());
		Long companyId = user.getCompanyId();
		//获取审核员角色对应的Id
		Long roleId = userDao.findAuthIdByName(SysRoleEnum.CHECK.getRole());
		List<CheckUserListReponseVO> checkUserList = userDao.getCheckUserList(limit,companyId,roleId);
		//查询总条数
		Integer total = userDao.selectUserTotalByRoleId(roleId);
		Integer totalPageNo = Page.getTotalPageNo(total,page.getPageSize());
		
		return new Page<CheckUserListReponseVO>(SysDicEnum.SUCCESS.getCode(),"审核员列表获取成功",page.getPageNum(),page.getPageSize(),total,totalPageNo,checkUserList);
		}catch (Exception e) {
			return Page.fail();
		}
	}
	
	/**
	 * 创建贷款审核人
	 */
	@Override
	public SysResponseVO createCheckUser(UserInfoDTO userInfoDTO,CreateUserInfoVO userVO) {
		User user = new User();
		/**
		 * 先校验用户名是否存在
		 */
		User userByUserName = userRepository.findByUsername(userVO.getUsername());
		if(userByUserName!=null) {
			//证明已经存在的用户
			return ResponseUtils.createResponse(SysDicEnum.HAS_USER);
		}
		BeanUtils.copyProperties(userVO, user);
		//数据库保存加密后的密码
		//查询数据库获取申贷人角色id
		ProRole loanApply = roleMapper.findByRoleName(SysRoleEnum.CHECK.getRole());
		user.setPassword(SCryptUtil.scrypt(user.getPassword(), 32768, 8, 1));
		user.setRoleId(loanApply.getId());
		user.setCompanyId(userInfoDTO.getCompanyId());
		try {
			userRepository.save(user);
		}catch (Exception e) {
			//保存的时候发生错误
			//返回系统异常
			return ResponseUtils.returnSysError();
		}
		return ResponseUtils.returnSuccess();
	}
	
	/**
	 * 根据用户id获取用户详细信息
	 */
	@Override
	public UserBaseBaseInfoReponseVO getBaseUserInfo(Long userId) {
		try {
			//获取用户基本信息
			UserBaseInfoDTO userBaseInfo = userDao.findUser(userId,SysDicEnum.SYS_VALID.getCode());
			UserBaseBaseInfoReponseVO result = new UserBaseBaseInfoReponseVO(SysDicEnum.SUCCESS.getCode(),"数据获取成功");
			result.setUserId(userBaseInfo.getId());
			result.setEmail(userBaseInfo.getEmail());
			OSSClientUtil ossClientUtil = new OSSClientUtil();
			String url = ossClientUtil.getHeadImageUrl(userBaseInfo.getHead_image());
			result.setHeadImage(url);
			result.setIdCard(ETLUtil.etlIdCard(userBaseInfo.getId_card()));
			result.setName(userBaseInfo.getName());
			result.setPhoneNumber(ETLUtil.etlPhoneNumber(userBaseInfo.getPhone_number()));
			return result; 
		}catch (Exception e) {
			return new UserBaseBaseInfoReponseVO(SysDicEnum.ERROR.getCode(),"用户信息获取失败");
		}
	}
	
	/**
	 * 修改审核人信息
	 */
	@Override
	public SysResponseVO updateCheckUserInfo(CheckUserReuqestDTO checkUserInfo) {
		try {
			CheckUserDTO checkUserDTO = new CheckUserDTO();
			BeanUtils.copyProperties(checkUserInfo, checkUserDTO);
			checkUserDTO.setPassWord(SCryptUtil.scrypt(checkUserInfo.getPassWord(), 32768, 8, 1));
			userDao.updateCheckUserInfo(checkUserDTO);
			return ResponseUtils.returnSuccess();
		}catch (Exception e) {
			//修改数据的时候发生错误
			e.printStackTrace();
			//返回系统异常
			return ResponseUtils.returnSysError();
		}
	}
}
