package com.pro.study.vo.response.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月28日上午3:04:26 
* @version:1.0
* @Description:工作流节点对应的返回类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkFlowNodeVO {
	
	private Long id;
	
	private String name;
}
