package com.pro.study.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月5日上午3:01:11 
* @version:1.0
* @Description: 贷款人分布地图数据传输介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationMapDto {
	
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
