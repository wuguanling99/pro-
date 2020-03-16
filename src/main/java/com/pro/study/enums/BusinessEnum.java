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
	LOANPURPOSE_MANAGEMENT(1,"经营"),
	LOANPURPOSE_CAPITAL_TURN_OVER(2,"资金周转"),
	LOANPURPOSE_HOUSE_DECORATION(3,"购房房屋"),
	LOANPURPOSE_BUY_CAR(4,"购车"),
	LOANPURPOSE_PER_CONSUME(5,"个人消费"),
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
	//====还款期限====
	REPAY_TYPE_4MONTH(1,"4个月"),
	REPAY_TYPE_6MONTH(2,"6个月"),
	REPAY_TYPE_10MONTH(3,"10个月"),
	REPAY_TYPE_12MONTH(4,"12个月"),
	REPAY_TYPE_20MONTH(5,"20个月"),
	REPAY_TYPE_24MONTH(6,"24个月"),
	REPAY_TYPE_36MONTH(7,"36个月"),
	;
	
	private Integer code;
	
	private String message;
}
