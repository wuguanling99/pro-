package com.pro.study.serviceimpl.user;

import java.text.ParseException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.lambdaworks.crypto.SCryptUtil;
import com.pro.study.dao.role.ProRoleRepository;
import com.pro.study.dao.user.UserRepository;
import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.enums.SysRoleEnum;
import com.pro.study.po.role.ProRole;
import com.pro.study.po.user.User;
import com.pro.study.service.user.UserService;
import com.pro.study.utils.ETLUtil;
import com.pro.study.utils.IdCardUtil;
import com.pro.study.utils.JWTUtil;
import com.pro.study.utils.RSAKeyUtils;
import com.pro.study.utils.ResponseUtils;
import com.pro.study.utils.UserUtils;
import com.pro.study.vo.request.user.CreateUserInfoVO;
import com.pro.study.vo.request.user.UserLoginVO;
import com.pro.study.vo.response.sys.SysResponseVO;
import com.pro.study.vo.response.user.LoanApplyTableUserBaseInfoVO;
import com.pro.study.vo.response.user.LoginResponseVO;
import com.pro.study.vo.response.user.LogoutResponseVO;

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

}
