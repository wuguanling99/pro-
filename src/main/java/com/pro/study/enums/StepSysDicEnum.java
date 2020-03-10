package com.pro.study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
* @author: wgl
* @date: 2020年3月7日下午2:13:16 
* @version:1.0
* @Description: 工作流节点枚举类
*/
@Getter
@AllArgsConstructor
public enum StepSysDicEnum {
	ALL_PUBLIC(0,"所有公司公开"),
	COMPANY_PUBLIC(1,"本公司所有产品内可见"),
	IN_PRODUCT(2,"本产品内可见"),
	;
	
	private Integer code;
	
	private String message;
}
