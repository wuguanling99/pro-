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
	
	private Long productId;
	
	private Long workflowId;

	private Integer pageNum;

	private Integer pageSize;
}
