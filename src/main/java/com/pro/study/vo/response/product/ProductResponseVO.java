package com.pro.study.vo.response.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月7日下午2:39:32 
* @version:1.0
* @Description: 产品返回对象
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseVO {
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 产品名
	 */
	private String productName;
	
	
	/**'
	 * 申请人数
	 */
	private Integer applyLoanerNum;

	/**
	 * 放款金额
	 */
	private Integer totalMoney;
	
	/**
	 * 创建时间
	 */
	private String createDate;
}
