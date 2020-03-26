package com.pro.study.vo.response.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月26日上午10:43:03 
* @version:1.0
* @Description:规则字段表现层
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleDicReponseVO {
	
	/**
	 * 字段id
	 */
	private Long fieldId;

	/**
	 * 字段名
	 */
	private String fieldName;
	
}
