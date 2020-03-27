package com.pro.study.vo.response.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月28日上午3:14:44 
* @version:1.0
* @Description:规则关联关系返回实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleLinkResponseVO {
	
	/**
	 * 规则id
	 */
	private Long ruleId;
	
	/**
	 * 规则名
	 */
	private String ruleName;

	/**
	 * 规则描述
	 */
	private String ruleDescribe;
	
	/**
	 * 关联关系  0:已关联 1:未关联
	 */
	private Integer linkType;
}
