package com.pro.study.vo.request.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
* @author: wgl
* @date: 2020年3月15日下午6:58:39 
* @version:1.0
* @Description:分页请求数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {

	private Integer pageNum;

	private Integer pageSize;
}
