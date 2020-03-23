package com.pro.study.dto.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月22日下午6:14:16 
* @version:1.0
* @Description:节点和下一个节点数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeAndNextNodeDTO {
	
	
	private Long id;
	
	/**
	 * 节点通过的下一个节点id
	 */
	private Long nextId;
	
	/**
	 * 开始节点结束节点标识
	 */
	private Integer startStop;
	
	/**
	 * 工作流id
	 */
	private Long workflowId;

}
