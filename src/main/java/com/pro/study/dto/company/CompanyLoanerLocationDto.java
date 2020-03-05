package com.pro.study.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月5日下午9:56:27 
* @version:1.0
* @Description: 公司贷款人分布数据介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyLoanerLocationDto {
	
	/**
	 * 数量
	 */
	private Integer total;
	
	/**
	 * 省份
	 */
	private String province;
	
	/**
	 * 城市
	 */
	private String city;
}
