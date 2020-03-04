package com.pro.study.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月4日上午12:31:59 
* @version:1.0
* @Description: 产品介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	/**
	 * 产品id
	 */
	private Long id;

	/**
	 * 产品名
	 */
	private String name;
}
