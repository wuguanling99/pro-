package com.pro.study.dto.company;

import java.util.Date;

import lombok.Data;

/**
 * 
* @author: wgl
* @date: 2020年3月16日上午7:16:08 
* @version:1.0
* @Description:贷款审核订单
 */
@Data
public class CheckLoanOrderDto {

	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 申请人姓名
	 */
	private String applicantName;
	/**
	 * 订单创建时间
	 */
	private Date create_time;
	/**
	 * 申请金额
	 */
	private Integer amount;
	/**
	 * 订单更新时间
	 */
	private Date updateTime;
	/**
	 * 订单状态
	 */
	private Integer orderType;
	/**
	 * 系统审核结论
	 */
	private String sysCheckResult;
	/**
	 * 产品名
	 */
	private String productName;
	
	
}
