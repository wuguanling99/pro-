package com.pro.study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月3日下午6:26:11 
* @version:1.0
* @Description: 贷款申请表枚举类
*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum SysLoanApplyTableEnum {
	//==========性别=========
	MAN(0,"男"),
	WOMAN(1,"女"),
	LENGTHBY18_IDCARD(18,"18位的身份证"),
	LENGTHBY15_IDCARD(15,"15位的身份证"),
	;
	
	
	private Integer code;
	
	private String message;
}
