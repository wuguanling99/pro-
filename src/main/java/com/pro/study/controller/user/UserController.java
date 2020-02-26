package com.pro.study.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.service.UserService;
import com.pro.study.utils.RandomValidateCodeUtil;
import com.pro.study.vo.ValidateCodeVO;


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
	* @Description:（创建用户的方法） 
	* 方法返回值: @param user
	* 方法返回值: @param request
	* 方法返回值: @throws IOException
	 */
	@PostMapping("/createUser")
	public void createUser(HttpServletRequest request,@RequestBody Map map) {
		System.out.println(map);
		System.out.println(request.getAttribute("sites"));
		
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