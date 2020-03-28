package com.pro.study.vo.request.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月28日上午3:45:41 
* @version:1.0
* @Description:规则关联分页请求
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RulePage {
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 节点id
	 */
	private Long nodeId;
		
	/**
	 * 当前页
	 */
	private Integer pageNum;

	/**
	 * 每页条数
	 */
	private Integer pageSize;
}
