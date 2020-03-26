package com.pro.study.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月25日上午2:26:11 
* @version:1.0
* @Description:产品详情数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {

	/**
	 * 产品Id
	 */
	private Long productId;

	/**
	 * 产品名
	 */
	private String productName;
	
	/**
	 * 产品描述
	 */
	private String productDecribe;

	/**
	 * 产品logo
	 */
	private String logoKey;
	
	/**
	 * logoUrl
	 */
	private String logoUrl;
}
