package com.pro.study.vo.request.loan_apply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月10日下午6:48:09 
* @version:1.0
* @Description:银行卡信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCardInfo {
	
	/**
	 * 银行卡卡号
	 */
	private String bankCardCode;
	
	/**
	 *银行卡对应开户行'
	 */
	private String bankName;
	
	/**
	 * 银行卡正面url
	 */
	private String bankCardUpImage;

	/**
	 * 银行卡反面url
	 */
	private String bankCardDownImage;
}
