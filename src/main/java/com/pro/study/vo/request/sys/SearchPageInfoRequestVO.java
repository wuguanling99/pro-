package com.pro.study.vo.request.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月20日上午1:47:35 
* @version:1.0
* @Description: 搜索分页请求VO类
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPageInfoRequestVO {
	/*
	 *页号 
	 */
	private Integer pageNum;

	/*
	 * 每页条数
	 */
	private Integer pageSize;

	/*
	 * 公司名
	 */
	private String companyName;
	
	/*
	 * 产品名
	 */
	private String productName;

	/**
	 * 订单状态
	 */
	private Integer orderType;
}
