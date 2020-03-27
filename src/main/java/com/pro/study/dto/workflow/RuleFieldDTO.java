package com.pro.study.dto.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月23日上午3:47:36 
* @version:1.0
* @Description:规则字段数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleFieldDTO {
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 字段id
	 */
	private Long id;
	
	/**
	 * 字段名
	 */
	private String fieldName;
	
	/**
	 * 字段对应jsonPath
	 */
	private String jsonPath;

	/**
	 * 公司id
	 */
	private Long companyId;
}