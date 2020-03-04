package com.pro.study.dto.company;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月4日上午12:30:25 
* @version:1.0
* @Description: 公司数据介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
	
	/**
	 * 公司id
	 */
	private Long id;
	
	/**
	 * 公司名
	 */
	private String companyName;
	
	
	/**
	 * 公司对应的产品列表
	 */
	private List<ProductDto> companyProduct;
}
