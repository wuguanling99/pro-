package com.pro.study.vo.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseInfoRequestVO {
	
	/**
	 * 用户id
	 */
	private Long userId;
	

	/**
	 * 手机号
	 */
	private String phoneNumber;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	
	/**
	 * 头像
	 */
	private String headImage;
}
