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

	//====删除=====
	SYS_DELETE(0,"删除"),
	SYS_VALID(1,"有效"),
	;

	private Integer code;
	
	private String message;


}
