package com.pro.study.vo.request.workflow;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月26日下午6:38:57 
* @version:1.0
* @Description:规则请求接收实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleAndBodyRequestVO {
	
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
	 * 规则体
	 */
	private List<BodyRequestVO> ruleBody;
}
