package com.pro.study.dto.role;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月19日上午2:52:36 
* @version:1.0
* @Description: 权限数据介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {
	/**
	 * id
	 */
	private Long id;
	/**
	 * 数据创建时间
	 */
	private Date create_time;
	/**
	 * 假删除标志
	 */
	private Integer delete_flag;
	/**
	 * 数据更新时间
	 */
	private Date update_time;
	/**
	 * 是否需要权限认证
	 */
	private Integer auth_flag;
	/**
	 * 是否需要解析
	 */
	private Integer decrypt_flag;
	
	/**
	 * 角色id
	 */
	private Long role_id;
	
	/**
	 * 角色名
	 */
	private String role_name;
	
	/**
	 * 接口url
	 */
	private String auth_url;
}
