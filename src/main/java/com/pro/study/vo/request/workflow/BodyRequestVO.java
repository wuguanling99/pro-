package com.pro.study.vo.request.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月26日下午6:41:23 
* @version:1.0
* @Description:规则体接受实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyRequestVO {
	
	private Integer type;
	
	private String name;
	
	private Long id;
}
