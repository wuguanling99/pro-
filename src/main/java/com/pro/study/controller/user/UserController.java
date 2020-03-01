package com.pro.study.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.enums.SysDicEnum;
import com.pro.study.service.user.UserService;
import com.pro.study.vo.request.user.CreateUserInfoVO;
import com.pro.study.vo.request.user.UserLoginVO;
import com.pro.study.vo.response.sys.SysResponseVO;
import com.pro.study.vo.response.user.LoginResponseVO;
import com.pro.study.vo.response.user.LogoutResponseVO;


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
	
	@PostMapping("/logout")
	public LogoutResponseVO logout(HttpServletRequest request) {
		String token = request.getHeader("token");
		return userService.logout(token);
	}
	
	
	/**
	 * 
	* @Description:（申请贷款人创建） 
	* 方法返回值: @param map
	 */
	@PostMapping("/createLoanApplicant")
	public SysResponseVO createUser(@Validated @RequestBody CreateUserInfoVO user) {
		return userService.createLoanApplicant(user);
	}
	
}