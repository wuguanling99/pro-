package com.pro.study.dto.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月22日下午3:18:14 
* @version:1.0
* @Description:工作流节点数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeDTO {
	
	/**
	 * id
	 */
	private Long id;
	
	/**
	 * 节点姓名
	 */
	private String name;
	
	/**
	 * 节点描述
	 */
	private String describe;
	
	/**
	 * 节点类型
	 */
	private Integer nodeType;

}
