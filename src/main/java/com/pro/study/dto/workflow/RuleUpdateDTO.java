package com.pro.study.dto.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月27日上午3:09:18 
* @version:1.0
* @Description:规则修改数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleUpdateDTO {
	
	/**
	 * 规则id
	 */
	private Long id;

	/**
	 * 公司id
	 */
	private Long companyId;
	
	/**
	 * 规则名
	 */
	private String ruleName;
	
	/**
	 * 规则描述
	 */
	private String describe;
	
	private String body;
}
