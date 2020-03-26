package com.pro.study.dto.workflow;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月26日下午7:26:10 
* @version:1.0
* @Description: 规则数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleDTO {

	/**
	 * 规则Id
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
	 * 规则体
	 */
	private Date createTime;
}
