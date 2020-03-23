package com.pro.study.po.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.enums.StepSysDicEnum;
import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月7日下午2:03:10 
* @version:1.0
* @Description: 节点实体
*/
@Data
@Entity
@Table(name = "step_node")
@org.hibernate.annotations.Table(appliesTo = "step_node",comment = "节点表")
public class StepNode extends BasePojo{
	
	/**
	 * 产品id
	 */
	@Column(name = "workflow_id",columnDefinition="bigint(255) default 0 COMMENT '产品id'")
	private Long workflowId;
	
	
	/**
	 * 节点名称
	 */
	@Column(name = "step_name",nullable=false,columnDefinition="varchar(100) COMMENT '节点名称'")
	private String stepName;
	
	/**
	 * 节点描述
	 */
	@Column(name = "step_describe",nullable=false,columnDefinition="varchar(255) COMMENT '节点描述'")
	private String stepDescribe;

	/**
	 * 节点类型
	 */
	@Column(name = "step_type",nullable=false,columnDefinition="int(2) COMMENT '节点类型'")
	private Integer stepType;
	
	/**
	 * 下一个节点id
	 */
	@Column(name = "pass_node_id",columnDefinition="int(2) COMMENT '通过的话下一个节点id'")
	private Integer passNodeId;
	
	/**
	 * 下一个节点id
	 */
	@Column(name = "start_stop",columnDefinition="int(2) COMMENT '通过的话下一个节点id'")
	private Integer startOrStop;
}
