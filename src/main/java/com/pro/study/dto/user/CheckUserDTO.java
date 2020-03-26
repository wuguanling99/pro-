package com.pro.study.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月24日下午8:47:05 
* @version:1.0
* @Description:审核员数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckUserDTO {
	
	/**
	 * 用户ID 
	 */
	private Long id;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 身份证号
	 */
	private String idCard;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 手机号
	 */
	private String phoneNumber;
	
	/**
	 * 密码
	 */
	private String passWord;
}
