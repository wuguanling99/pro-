package com.pro.study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
* @author: wgl
* @date: 2020年2月23日下午2:38:12 
* @version:1.0
* @Description: 风控审核状态枚举类
*/
@Getter
@AllArgsConstructor
public enum RiskCheckEnum {
	CHECK_TO_BE_AUDITED(0,50,"待审核","待审核系统异常"),
	CHECK_BEGIN(1,51,"开始审核","开始审核异常"),
	CHECK_ALLOW_INTO_BEGIN(2,52,"准入审核开始","准入规则开始审核异常"),
	CHECK_ALLOW_INTO_ING(3,53,"准入审核中","准入规则审核过程中异常"),
	CHECK_ALLOW_INTO_OVER(4,54,"准入审核结束","准入规则审核结束异常"),
	CHECK_PCS_BEGIN(5,55,"外部接口审核开始","外部接口审核开始异常"),
	CHECK_PCS_ING(6,56,"外部接口审核中","外部接口审核中异常"),
	CHECK_PCS_OVER(7,57,"外部接口审核结束","外部接口审核结束异常"),
	CHECK_MODEL_BEGIN(8,58,"大数据风控模型审核开始","风控模型开始审核异常"),
	CHECK_MODEL_ING(9,59,"大数据风控模型审核中","风控模型审核中发生异常"),
	CHECK_MODEL_OVER(10,60,"大数据风控模型审核结束","风控模型审核结束发生异常"),
	CHECK_PER_TO_BE_READ(10,60,"人工审核待阅","人工审核待阅发生异常"),
	CHECK_PER_READED(10,60,"人工审核已阅","人工审核已阅异常"),
	CHECK_PER_OVER(10,60,"人工审核结束","人工审核结束异常"),
	CHECK_OVER(11,61,"审核结束","审核结束时发生异常"),
	;
	private Integer code;
	
	private Integer errorCode;
	
	private String message;	
	
	private String errorMsg;
}
