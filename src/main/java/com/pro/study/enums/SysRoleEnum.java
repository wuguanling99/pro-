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
	IT_ADMIN("admin","管理员"),
	CHECK("sheck","审核员"),
	LOAN_APPLY("loan_apply","贷款申请人"),
	COMPANY_MANAGER("company_manager","公司管理员"),
	PASSROLE("pass","不校验权限直接通过"),
	;
	private String role;
	
	private String roleMsg;
}
