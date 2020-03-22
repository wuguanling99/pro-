package com.pro.study.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年2月29日上午1:35:57 
* @version:1.0
* @Description:角色传输类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
	/**
	 * 角色id
	 */
	private Long id;
	
	/**
	 * 角色名
	 */
	private String role_name;
	
	/**
	 * 角色描述
	 */
	private String role_describe;
	
}
