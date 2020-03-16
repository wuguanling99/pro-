package com.pro.study.vo.response.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月15日上午2:37:35 
* @version:1.0
* @Description:审核列表数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToBeAuditedOrder {
	/**
	 * 订单id
	 */
	private Long orderId;
	
	/**
	 * 申请人姓名
	 */
	private String name;
	
	/**
	 * 申请金额
	 */
	private Integer applyAmount;
	
	/**
	 * 申请时间
	 */
	private String applyTime;

	/**
	 * 系统审核结论
	 */
	private String sysCheckResult;
}
