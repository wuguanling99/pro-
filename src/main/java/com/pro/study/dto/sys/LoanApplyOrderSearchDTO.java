package com.pro.study.dto.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月20日上午3:17:38 
* @version:1.0
* @Description:贷款申请订单数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplyOrderSearchDTO {
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/*
	 *页号 
	 */
	private Integer limitStart;

	/*
	 * 每页条数
	 */
	private Integer limitEnd;

	/*
	 * 公司名
	 */
	private String companyName;
	
	/*
	 * 产品名
	 */
	private String productName;

	/**
	 * 订单状态
	 */
	private Integer orderType;
}
