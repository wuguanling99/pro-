package com.pro.study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
* @author: wgl
* @date: 2020年2月23日下午2:09:12 
* @version:1.0
* @Description:系统角色枚举类 
*/
@Getter
@AllArgsConstructor
public enum SysRoleEnum {
	ADMIN("admin","管理员"),
	CHECK("sheck","审核员"),
	;
	private String role;
	
	private String roleMsg;
}
