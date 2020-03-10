package com.pro.study.vo.response.loan_apply;

import lombok.AllArgsConstructor;
import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月4日上午12:11:22 
* @version:1.0
* @Description: 创建贷款申请表返回vo
*/
@Data
@AllArgsConstructor
public class CreateLoanApplyTableResponseVO {
	
	/**
	 * 请求编码
	 */
	private Integer code;
	
	/**
	 * 消息
	 */
	private String message;
}
