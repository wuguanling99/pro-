package com.pro.study.vo.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月24日上午4:10:37 
* @version:1.0
* @Description: 审核员列表数据
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckUserListReponseVO {
	
	/**
	 * 主键Id
	 */
	private Long id;
	
	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 手机号
	 */
	private String phoneNumber;
	
	/**
	 * 邮箱
	 */
	private String email;
}
