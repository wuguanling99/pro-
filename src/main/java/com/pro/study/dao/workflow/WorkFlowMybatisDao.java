package com.pro.study.dao.workflow;

import org.apache.ibatis.annotations.Param;

import com.pro.study.dto.workflow.NodeDTO;
import com.pro.study.dto.workflow.WorkFlowDTO;

public interface WorkFlowMybatisDao {
	/**
	 * 
	* @Description:（添加工作流） 
	* 方法返回值: @param workFlow
	 */
	void insertWorkFlow(@Param("workflow")WorkFlowDTO workFlow);
	
	/**
	 * 
	* @Description:（添加工作流） 
	* 方法返回值: @param nodeData
	 */
	void insertNode(@Param("node")NodeDTO node);

}
