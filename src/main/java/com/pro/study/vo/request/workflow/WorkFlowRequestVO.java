package com.pro.study.vo.request.workflow;

import java.util.List;

import lombok.Data;

/**
 * 
* @author: wgl
* @date: 2020年3月15日上午2:01:20 
* @version:1.0
* @Description:创建工作流请求对象
 */
@Data
public class WorkFlowRequestVO {
	
	/**
	 * 工作流名
	 */
	private String name;
	
	/**
	 * 工作流描述
	 */
	private String describe;
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 节点列表
	 */
	private List<NodeRequestVO> nodeList;  
	
}
