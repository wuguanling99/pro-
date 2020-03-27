package com.pro.study.po.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月23日上午3:02:17 
* @version:1.0
* @Description: 规则字段
*/
@Data
@Entity
@Table(name = "pro_rule_field")
@org.hibernate.annotations.Table(appliesTo = "pro_rule_field",comment = "规则字段表")
public class RuleField extends BasePojo{
	
	/**
	 * 字段名
	 */
	@Column(name = "field_name",nullable=false,columnDefinition="varchar(100) default 0 COMMENT '字段名'")	
	private String fieldName;
	
	/**
	 * 公司id
	 */
	@Column(name = "product_id",nullable=false,columnDefinition="bigint(255) default 0 COMMENT '产品id'")
	private Long productId;
	
	/**
	 * 公司id
	 */
	@Column(name = "company_id",nullable=false,columnDefinition="bigint(255) default 0 COMMENT '公司id'")
	private Long companyId;
	
	/**
	 * 字段对应jsonPath
	 */
	@Column(name = "json_path",nullable=false,columnDefinition="varchar(100) default 0 COMMENT '字段对应jsonPath'")
	private String jsonPath;
}
