package com.pro.study.vo.request.user;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月1日下午4:35:32 
* @version:1.0
* @Description: 创建用户VO类
*/
@Data
public class CreateUserInfoVO {
	
	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空")
	private String username;
	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空")
	private String password;

	/**
	 * 姓名
	 */
	@NotBlank(message = "姓名不能为空")
	private String name;
	/**
	 * 身份证号
	 */
	@NotBlank(message = "身份证号不能为空")
	private String idCard;
	
	/**
	 * 邮箱
	 */
	@NotBlank(message = "邮箱不能为空")
	private String email;
	
	/**
	 * 手机号
	 */
	@NotBlank(message = "手机号不能为空")
	private String phoneNumber;
	
}
