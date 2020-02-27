package com.pro.study.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.service.user.UserService;
import com.pro.study.utils.RandomValidateCodeUtil;
import com.pro.study.vo.ValidateCodeVO;
import com.pro.study.vo.user.LoginResponseVO;
import com.pro.study.vo.user.UserLoginVO;
import com.pro.study.vo.user.UserVO;


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
	public LoginResponseVO login(@Validated UserLoginVO loginVo) {
		return userService.login(loginVo);
	}
	
	
	/**
	 * 
	* @Description:（申请贷款人创建） 
	* 方法返回值: @param user
	* 方法返回值: @param request
	* 方法返回值: @throws IOException
	 */
	@PostMapping("/createUser")
	public void createUser(HttpServletRequest request,@RequestBody UserVO map) {
	}
	
	/**
	 * 
	* @Description:（获取图形验证码） 
	* 方法返回值: @param user
	* 方法返回值: @param request
	* 方法返回值: @throws IOException
	 */
	@GetMapping("/createValidateCode")
	public ValidateCodeVO createValidateCode() {
		RandomValidateCodeUtil randomValidateCodeUtil = new RandomValidateCodeUtil();
		Map<String, String> randcode = randomValidateCodeUtil.getRandcode();
		return new ValidateCodeVO(randcode.get("num"),randcode.get("pic"));
	}
	
}