package com.pro.study.dto.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月28日上午7:01:16 
* @version:1.0
* @Description:外部数据接口数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutInterfaceDTO {
	
	/**
	 * 接口Id
	 */
	private Long id;
	
	/**
	 * 接口名
	 */
	private String name;
	
	/**
	 * 接口编号
	 */
	private String code;
	
	/**
	 * 提供接口的公司
	 */
	private String companyName;
	
	/**
	 * 扣费方式
	 */
	private Integer costType;
	
	/**
	 * 扣费金额
	 */
	private Double oneCost;
	
	/**
	 * 管理id
	 */
	private Long linkId;
	
}
