package com.pro.study.vo.response.sys;

import lombok.AllArgsConstructor;
import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月1日下午4:59:03 
* @version:1.0
* @Description: 系统接口返回VO
*/
@Data
@AllArgsConstructor
public class SysResponseVO {
	/**
	 * 返回码
	 */
	private Integer code;
	
	/**
	 * 消息
	 */
	private String message;

}
