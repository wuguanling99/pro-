package com.pro.study.vo.response.workflow;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月28日上午2:41:43 
* @version:1.0
* @Description: 工作流和工作流节点返回表现层
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkFlowAndNodeResponseVO {

	/**
	 * 工作流id
	 */
	private Long id;
	
	/**
	 * 工作流名称
	 */
	private String workFlowName;
	
	/**
	 * 对应工作流节点的数据
	 */
	private List<WorkFlowNodeVO> nodeData;
}
