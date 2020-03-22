package com.pro.study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月22日下午5:24:56 
* @version:1.0
* @Description: 系统节点枚举类
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum NodeEnum {
	SYS_NODE(0,"系统节点"),
	CUSTOM_NODE(1,"自定义节点"),
	;
	private Integer code;
	
	private String message;
}
