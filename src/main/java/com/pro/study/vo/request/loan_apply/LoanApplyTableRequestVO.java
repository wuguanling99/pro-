package com.pro.study.vo.request.loan_apply;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月4日上午12:09:54 
* @version:1.0
* @Description: 贷款申请表请求vo
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplyTableRequestVO {

	/**
	 * 个人基本信息
	 */
	private PerInfoVO perinfo;
	
	/**
	 * 贷款信息
	 */
	private LoanInfoVO loanInfo;
	
	/**
	 * 银行卡信息
	 */
	private List<BankCardInfo> bankCardList;
		
	/**
	 * 信用卡信息
	 */
	private List<CreditCardInfo> creditCardList;
	
	/**
	 * 联系人信息
	 */
	private List<LinkPerInfo> linkPerInfoList;
}
