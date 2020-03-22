package com.pro.study.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月19日上午4:15:58 
* @version:1.0
* @Description: 用户数据介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseInfoDTO {
	

	/**
	 * id
	 */
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 身份证
	 */
	private String id_card;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 手机号
	 */
	private String phone_number;
	
	/**
	 * 头像
	 */
	private String head_image;
}
