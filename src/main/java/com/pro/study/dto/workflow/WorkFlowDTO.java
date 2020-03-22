package com.pro.study.dto.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月22日上午3:57:02 
* @version:1.0
* @Description:工作流数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkFlowDTO {
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 公司id
	 */
	private Long companyId;
	/**
	 * 产品id
	 */
	private Long productId;
	/**
	 * 描述
	 */
	private String describe;
	/**
	 * 工作流名称
	 */
	private String workflowName;
}
