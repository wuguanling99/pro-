package com.pro.study.vo.request.loan_apply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月10日下午6:44:45 
* @version:1.0
* @Description:信用卡信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardInfo {
	
	/**
	 * 信用卡卡号
	 */
	private String creditCardCode;
	
	/**
	 * 信用卡开户行
	 */
	private String creditName;
	
	/**
	 * 信用卡正面
	 */
	private String creditCardUpImage;

	/**
	 * 信用卡反面
	 */
	private String creditCardDownImage;
}
