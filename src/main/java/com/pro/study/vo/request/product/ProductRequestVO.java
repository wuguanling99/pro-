package com.pro.study.vo.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月24日下午9:20:53 
* @version:1.0
* @Description: 产品信息请求实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestVO {
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 产品名
	 */
	private String productName;
	
	/**
	 * 产品描述
	 */
	private String productDescribe;
	
	/**
	 * 产品logo
	 */
	private String logoKey;
}
