package com.pro.study.vo.request.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeRequestVO {
	
	/**
	 * 节点名称
	 */
	private String nodeName;
	
	/**
	 * 节点描述
	 */
	private String nodeDescribe;

	/**
	 * id
	 */
	private Long id;
}
