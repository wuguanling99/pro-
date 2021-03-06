package com.pro.study.vo.request.workflow;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月23日上午3:23:28 
* @version:1.0
* @Description: 规则字段接受实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleFieldRequestVO {
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 字段名
	 */
	private String fieldName;
	
	/**
	 * 字段jsonPath
	 */
	private String jsonPath;
	
	/**
	 * 规则字段字典数组
	 */
	private List<RuleFieldDicVO> rueFieldList;
}
