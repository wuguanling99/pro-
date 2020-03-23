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
	//========启动节点==========
	START_CODE(0,"启动节点"),
	END_CODE(-1,"结束节点"),
	ING(1,"过程中节点"),
	//========节点类型==========
	NODE_TYPE_SYS_NODE(0,"系统节点"),
	NODE_TYPE_CUSTOM_NODE(1,"自定义节点"),
	;
	private Integer code;
	
	private String message;
}
