package com.pro.study.dto.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月28日上午3:24:07 
* @version:1.0
* @Description:规则关联数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleLinkDTO {
	
	/**
	 * 规则id
	 */
	private Long id;
	
	/**
	 * 规则名
	 */
	private String ruleName;
	
	/**
	 * 规则描述
	 */
	private String ruleDescribe;
	
	/**
	 * 关联的工作流id
	 */
	private Long nodeId;
}
