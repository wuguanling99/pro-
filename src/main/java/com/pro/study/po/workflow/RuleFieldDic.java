package com.pro.study.po.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/**
 * 
* @author: wgl
* @date: 2020年3月23日上午3:08:15 
* @version:1.0
* @Description:
 */
@Data
@Entity
@Table(name = "rule_field_dic")
@org.hibernate.annotations.Table(appliesTo = "rule_field_dic",comment = "规则字段字典表")
public class RuleFieldDic extends BasePojo{

	/**
	 * 对应规则字段id
	 */
	@Column(name = "field_id",nullable=false,columnDefinition="bigint(255) default 0 COMMENT '对应规则字段id'")	
	private Long fieldId;
	
	/**
	 * 字段字典名
	 */
	@Column(name = "field_dic_name",nullable=false,columnDefinition="varchar(100) default 0 COMMENT '字段字典名'")
	private String fieldDicName;
	
	/**
	 * 字段对应的值
	 */
	@Column(name = "field_value",nullable=false,columnDefinition="int(20) default 0 COMMENT '字段对应的值'")
	private Integer fieldDicValue;
	
	/**
	 * 系统中字段对应的值
	 */
	@Column(name = "sys_field_value",nullable=false,columnDefinition="int(20) default 0 COMMENT '系统中字段对应的值'")
	private String sysFieldValue;
}
