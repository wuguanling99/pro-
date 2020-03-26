package com.pro.study.po.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月26日下午6:45:16 
* @version:1.0
* @Description: 规则实体类
*/
/** 
* @author: wgl
* @date: 2020年3月6日下午5:17:27 
* @version:1.0
* @Description: 工作流
*/
@Data
@Entity
@Table(name = "pro_rule")
@org.hibernate.annotations.Table(appliesTo = "pro_rule",comment = "规则实体")
public class Rule extends BasePojo{
	
	/**
	 * 规则名
	 */
	@Column(name = "company_id",nullable=false,columnDefinition="bigint(255) default 0 COMMENT '公司id'")
	private Long companyId;
	
	/**
	 * 规则名
	 */
	@Column(name = "rule_name",nullable=false,columnDefinition="varchar(255) default 0 COMMENT '规则名'")
	private String ruleName;
	
	/**
	 * 规则描述
	 */
	@Column(name = "rule_describe",nullable=false,columnDefinition="varchar(255) default 0 COMMENT '规则描述'")
	private String ruleDescribe;
	
	/**
	 * 规则实体
	 */
	@Column(name = "rule_body",nullable=false,columnDefinition="text(500) COMMENT '规则实体'")
	private String ruleBody;
}
