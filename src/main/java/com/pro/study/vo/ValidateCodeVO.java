package com.pro.study.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/** 
* @author: wgl
* @date: 2020年2月24日上午12:14:11 
* @version:1.0
* @Description: 验证码VO类
*/
@Data
@AllArgsConstructor
public class ValidateCodeVO {

	private String code;
	
	private String img;
}
