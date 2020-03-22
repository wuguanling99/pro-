package com.pro.study.dto.loanApply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月21日上午3:20:01 
* @version:1.0
* @Description:银行卡数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanBankDTO {
	
	/**
	 * 银行卡号
	 */
	private String code;
	
	/**
	 * 银行卡反面照
	 */
	private String downImage;
	
	/**
	 * 银行卡正面照
	 */
	private String upImage;
	
	/**
	 * 银行名
	 */
	private String bankName;
	/**
	 * 订单Id
	 */
	private Long orderId;

}
