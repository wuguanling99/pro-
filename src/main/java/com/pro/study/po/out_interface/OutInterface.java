package com.pro.study.po.out_interface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;
import com.pro.study.po.product.Product;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月6日下午4:37:42 
* @version:1.0
* @Description: 外部数据源实体
*/
@Data
@Entity
@Table(name = "out_interface")
@org.hibernate.annotations.Table(appliesTo = "out_interface",comment = "外部数据接口表")
public class OutInterface extends BasePojo{
	
	/**
	 * 接口编码
	 */
	@Column(name = "interface_code",unique = true,nullable = false,columnDefinition="varchar(255) COMMENT '接口编码'")
	private String interfaceCode;
	
	/**
	 * 请求成功返回json样例
	 */
	@Column(name = "response_success_example",nullable = false,columnDefinition="text(500) COMMENT '接口请求成功返回样例'")
	private String responseSuccessExample;

	/**
	 * 返回成功标识jsonPath
	 */
	@Column(name = "success_jsonpath",nullable = false,columnDefinition="varchar(50) COMMENT '请求判断成功用的jsonPath'")
	private String successFlagJsonPath;
	
	/**
	 * 返回成功对应的结果
	 */
	@Column(name = "jsonpath_result",nullable = false,columnDefinition="varchar(50) COMMENT '请求判断成功用的jsonPath'")
	private String successFlagJsonResult;

	/**
	 * 接口url
	 */
	@Column(name = "interface_url",nullable = false,columnDefinition="text(255) COMMENT '接口地址'")
	private String interfaceUrl;

	/**
	 * 接口描述
	 */
	@Column(name = "interface_describe",nullable = false,columnDefinition="varchar(255) COMMENT '接口描述'")
	private String interfaceDescribe;
	
	/**
	 * 扣费方式
	 */
	@Column(name = "cost_type",nullable = false,columnDefinition="varchar(50) COMMENT '扣费方式'")
	private String costType;
	
	/**
	 * 扣费金额
	 */
	@Column(name = "one_cost",nullable = false,columnDefinition="int(10) COMMENT '扣费金额'")
	private Integer one_cost;
}
