package com.pro.study.po.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;
import com.pro.study.po.out_interface.OutInterface;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月6日下午5:17:27 
* @version:1.0
* @Description: 工作流
*/
@Data
@Entity
@Table(name = "pro_workflow")
@org.hibernate.annotations.Table(appliesTo = "pro_workflow",comment = "工作流")
public class ProWorkFlow extends BasePojo{
	
	/**
	 * 公司id
	 */
	@Column(name = "company_id",nullable=false,columnDefinition="bigint(255) default 0 COMMENT '公司id'")
	private Long companyId;
	
	/**
	 * 产品id
	 */
	@Column(name = "product_id",columnDefinition="bigint(255) default 0 COMMENT '产品id'")
	private Long productId;
	/**
	 * 工作流名字
	 */
	@Column(name = "workflow_name",nullable=false,columnDefinition="varchar(100) COMMENT '工作流名称'")
	private String workflowName;
	
	/**
	 * 工作流描述
	 */
	@Column(name = "workflow_describe",columnDefinition="varchar(255) COMMENT '工作流描述'")
	private String workflowDescribe;
	

}
