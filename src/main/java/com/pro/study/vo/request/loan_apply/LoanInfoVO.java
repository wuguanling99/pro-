package com.pro.study.vo.request.loan_apply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月10日下午5:47:00 
* @version:1.0
* @Description: 贷款基本信息
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanInfoVO {
	
	/**
	 * 公司id
	 */
	private Long companyId;
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 还款期限
	 */
	private Integer repayType;
	/**
	 * 贷款用途
	 */
	private Integer loanUseType;
	
	/**
	 * 还款值
	 */
	private Integer repayment;
}
