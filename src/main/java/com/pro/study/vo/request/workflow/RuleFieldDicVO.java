package com.pro.study.vo.request.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月23日上午3:26:15 
* @version:1.0
* @Description:规则字段字典
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleFieldDicVO {
	
	/**
	 * 字段名
	 */
	private String fieldName;
	
	/**
	 * 系统对应的值
	 */
	private Integer sysValue;
	
	/**
	 * 字段对应的值
	 */
	private Integer fieldValue;
}
