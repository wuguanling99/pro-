package com.pro.study.dto.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月23日上午3:52:47 
* @version:1.0
* @Description:规则字段字典数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleFieldDicDTO {

	/**
	 * 对应的规则字段id
	 */
	private Long fieldId;
	
	/**
	 * 字段名
	 */
	private String fieldName;

	/**
	 * 系统对应的值
	 */
	private Integer sysValue;
	
	/**
	 * 设置的字典对应的值
	 */
	private Integer keyValue;
}