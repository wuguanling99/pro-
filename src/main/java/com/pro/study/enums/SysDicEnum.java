package com.pro.study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;





/** 
* @author: wgl
* @date: 2020年2月23日下午1:58:12 
* @version:1.0
* @Description: 系统枚举类
*/
@Getter
@AllArgsConstructor
public enum SysDicEnum {
	//======规则======
	RULE_LINK(1,"关联"),
	RULE_DONT_LINK(0,"未关联"),
	//======照片正反面========
	UP_FACE(0,"正面"),
	DOWN_FACE(1,"反面"),
	//=====上传成功====
	OSS_UPLOAD_SUCCESS(0,"上传成功"),
	OSS_UPLOAD_FAILD(1,"上传失败"),
	//====删除=====
	SYS_VALID(0,"有效"),
	SYS_DELETE(1,"删除"),
	//====response 枚举 =======
	SUCCESS(0,"请求成功"),
	ERROR(1,"请求失败"),
	USERNAMEORPASSWORDERROR(2,"用户或密码错误"),
	HAS_USER(1,"用户已存在"),
	SYS_ERROR(1,"系统异常"),
	//=========接口权限========
	DONTNEED(0,"不需要"),
	NEED(1,"需要"),
	//===========目录=========
	SYS_PARENT_MENU(0,"根目录id")
	;

	private Integer code;
	
	private String message;


}
