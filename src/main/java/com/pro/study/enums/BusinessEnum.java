package com.pro.study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
* @author: wgl
* @date: 2020年2月23日下午1:40:25 
* @version:1.0
* @Description: 业务枚举类
*/
@Getter
@AllArgsConstructor
public enum BusinessEnum {

	//====婚姻信息====
	MARRYINFO_MARRIED(0,"已婚"),
	MARRYINFO_UNMARRIED(1,"未婚"),
	MARRYINFO_DIVORCE(2,"离异"),
	MARRYINFO_OFF_WIFE(3,"丧偶"),
	//=====性别信息====
	SEX_MAN(0,"男"),
	SEX_WOMAN(1,"女"),
	//=====贷款用途======
	LOANPURPOSE_MANAGEMENT(1,"¾­Óª"),
	LOANPURPOSE_CAPITAL_TURN_OVER(2,"×Ê½ðÖÜ×ª"),
	LOANPURPOSE_HOUSE_DECORATION(3,"·¿ÎÝ×°ÐÞ"),
	LOANPURPOSE_BUY_CAR(4,"¹º³µ"),
	LOANPURPOSE_PER_CONSUME(5,"¸öÈËÏû·Ñ"),
	//====教育程度====
	EDU_MASTER_AND_ABOVE(1,"硕士及以上"),
	EDU_COLLEGE(2,"本科"),
	EDU_JUNIOR_COLLEGE(3,"大专"),
	//====购房信息====
	HOUSE_TYPE_BUY_PER(1,"自购"),
	HOUSE_TYPE_RELATIVES(2,"亲属"),
	HOUSE_TYPE_DORMITORY(3,"单位宿舍"),
	HOUSE_TYPE_RENTING(4,"租房"),
	HOUSE_TYPE_MORTGAGE(5,"按揭"),
	//====
	;
	
	private Integer code;
	
	private String message;
}
