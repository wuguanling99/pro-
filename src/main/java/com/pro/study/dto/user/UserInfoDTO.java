package com.pro.study.dto.user;

import lombok.Data;
/**
 * 
* @author: wgl
* @date: 2020年3月2日上午2:00:02 
* @version:1.0
* @Description: 用户VO
 */
@Data
public class UserInfoDTO {
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 角色
	 */
	private String role;
	
	/**
	 * roleid
	 */
	private Long roleId;

}
