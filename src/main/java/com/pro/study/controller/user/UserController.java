package com.pro.study.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.service.user.UserService;
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
import com.pro.study.vo.response.user.LoginResponseVO;
import com.pro.study.vo.response.user.LogoutResponseVO;
import com.pro.study.vo.response.user.UserBaseBaseInfoReponseVO;


/** 
* @author: wgl
* @date: 2020年2月23日下午1:38:12 
* @version:1.0
* @Description: 用户视图层
*/
@RestController
@RequestMapping("/user")
public class UserController{
	
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 
	* @Description:（申请贷款人创建） 
	* 方法返回值: @param loginVo 登陆用的vo
	* 方法返回值: @return
	 */
	@PostMapping("/login")
	public LoginResponseVO login(@Validated @RequestBody UserLoginVO loginVo) {
		try {
			return userService.login(loginVo);
		}catch (Exception e) {
			return new LoginResponseVO(SysDicEnum.ERROR.getCode(),"",SysDicEnum.ERROR.getMessage());
		}
	}
	
	@GetMapping("/logout")
	public LogoutResponseVO logout(HttpServletRequest request) {
		String token = request.getHeader("token");
		return userService.logout(token);
	}
	
	
	/**
	 * 
	* @Description:（申请贷款人创建） 
	* 方法返回值: @param CreateUserInfoVO
	 */
	@PostMapping("/createLoanApplicant")
	public SysResponseVO createUser(@Validated @RequestBody CreateUserInfoVO user) {
		return userService.createLoanApplicant(user);
	}
	
	/**
	 * 
	* @Description:（获取用户基本信息） 
	* 方法返回值:
	 */
	@GetMapping("/getUserBaseInfo")
	public UserBaseBaseInfoReponseVO getUserBaseInfo(HttpServletRequest request) {
		return userService.getBaseUserInfo(UserUtils.getUser(request));
	}

	/**
	 * 
	* @Description:（修改个人基本信息） 
	* 方法返回值: @return
	 */
	@PostMapping("/updatePerBaseInfo")
	public UserBaseBaseInfoReponseVO updateBaseInfo(@RequestBody UserBaseInfoRequestVO userBaseInfo) {
		return userService.updateBaseInfo(userBaseInfo);
	}
	
	/**
	 * 
	* @Description:（头像上传） 
	* 方法返回值: @param request
	* 方法返回值: @param file
	* 方法返回值: @return
	 */
	@PostMapping("/uploadUserHeadImage")
	public ImageReponseVO uploadUserHeadImage(HttpServletRequest request,@RequestParam(value = "file") MultipartFile file) {
		return userService.uploadUserHeadImage(UserUtils.getUser(request),file);
	}
	
	/**
	 * 
	* @Description:（获取所有审核员列表） 
	* 方法返回值: @return
	 */
	@GetMapping("/getCheckUserList")
	public Page<CheckUserListReponseVO> getCheckUserList(HttpServletRequest request,@RequestBody PageInfo page) {
		UserInfoDTO user = UserUtils.getUser(request);
		return userService.getCheckUserList(user,page);
	}
	
	/**
	 * 
	* @Description:（创建贷款申请人） 
	* 方法返回值: @return
	 */
	@PostMapping("/createCheckUser")
	public SysResponseVO createCheckUser(HttpServletRequest request,@Validated @RequestBody CreateUserInfoVO userInfo) {
		return userService.createCheckUser(UserUtils.getUser(request),userInfo);
	}
	
	/**
	 * 
	* @Description:（创建贷款申请人） 
	* 方法返回值: @return
	 */
	@GetMapping("/getCheckUserInfo")
	public UserBaseBaseInfoReponseVO getCheckUserInfo(@RequestParam("userId")Long userId) {
		return userService.getBaseUserInfo(userId);
	}
	
	/**
	 * 
	* @Description:（更新贷款申请人） 
	* 方法返回值: @return
	 */
	@GetMapping("/updateCheckUserInfo")
	public SysResponseVO updateCheckUserInfo(@RequestBody CheckUserReuqestDTO checkUserInfo) {
		return userService.updateCheckUserInfo(checkUserInfo);
	}
}