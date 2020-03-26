package com.pro.study.vo.response.company;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月26日上午10:40:43 
* @version:1.0
* @Description: 规则和规则字段返回表现层
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleFieldAndDicReponseVO {

	/**
	 * 规则字段id
	 */
	private Long fielId;
	
	/**
	 * 规则字段名
	 */
	private String fieldName;
	
	
	private List<RuleDicReponseVO> dicData;
}
