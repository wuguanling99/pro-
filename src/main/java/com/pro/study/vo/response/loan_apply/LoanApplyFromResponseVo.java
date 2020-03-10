package com.pro.study.vo.response.loan_apply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月6日下午11:31:45 
* @version:1.0
* @Description: 贷款申请表返回类
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplyFromResponseVo {
	
	/**
	 * 订单id
	 */
	private Long orderId;
	
	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 订单姓名
	 */
	private String name;
	/**
	 * 订单创建时间
	 */
	private String createDate;

	/**
	 * 公司id
	 */
	private Long companyId;
	
	/**
	 * 公司名
	 */
	private String companyNmae;

	/**
	 * 产品Id
	 */
	private Long productId;
	
	/**
	 * 产品名
	 */
	private String productName;
	
	/**
	 * 贷款金额
	 */
	private Integer applyAmount; 
	
	/**
	 * 订单状态
	 */
	private String loanType;
	
}