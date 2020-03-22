package com.pro.study.dto.loanApply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月20日下午9:57:01 
* @version:1.0
* @Description:贷款申请订单数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplyOrderDTO {
	
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 公司id
	 */
	private Long companyId;
	
	/**
	 * 贷款用途
	 */
	private Integer useType;
	
	/**
	 * 订单状态
	 */
	private Integer orderType;
	
	/**
	 * 产品Id
	 */
	private Long productId;
	
	/**
	 * 还款期限
	 */
	private Integer repayType;
	
	/**
	 * 最高还款金额
	 */
	private Integer repayment;
	
	/**
	 * 用户Id
	 */
	private Long userId;
	/**
	 * 申请金额
	 */
	private Integer amount;
}
