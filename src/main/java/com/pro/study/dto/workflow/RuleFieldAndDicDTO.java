package com.pro.study.dto.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月26日上午11:48:17 
* @version:1.0
* @Description: 规则字段和规则字典数据介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleFieldAndDicDTO {

	/**
	 * 规则字段id
	 */
	private Long fieldId;
	
	/**
	 * 规则字段名
	 */
	private String fieldName;
	
	/**
	 * 规则字典id
	 */
	private Long fieldDicId;
	
	/**
	 * 规则字典名
	 */
	private String fieldDicName;
	
}
