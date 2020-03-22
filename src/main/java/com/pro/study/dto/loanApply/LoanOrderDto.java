package com.pro.study.dto.loanApply;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月20日上午3:03:55 
* @version:1.0
* @Description:审核订单数据介质
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanOrderDto {
	/**
	 * 订单id
	 */
	private Long orderId;
	
	/**
	 * 申请人姓名
	 */
	private String applyName;

	/**
	 * 公司名
	 */
	private String companyName;
	
	/**
	 * 产品名
	 */
	private String productName;
	
	/**
	 * 申请金额
	 */
	private Integer applyAmount;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 订单状态
	 */
	private Integer orderType;
}
