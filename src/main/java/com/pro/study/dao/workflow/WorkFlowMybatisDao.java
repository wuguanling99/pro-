package com.pro.study.dao.workflow;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pro.study.dto.workflow.NodeAndNextNodeDTO;
import com.pro.study.dto.workflow.NodeDTO;
import com.pro.study.dto.workflow.RuleFieldDTO;
import com.pro.study.dto.workflow.RuleFieldDicDTO;
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
	
	/**
	 * 
	* @Description:（更新节点数据） 
	* 方法返回值: @param nodeAndNextList
	 */
	void updateNodeAndNextCode(@Param("node")List<NodeAndNextNodeDTO> nodeAndNextList);

	/**
	 * 
	* @Description:（添加规则字段） 
	* 方法返回值: @param ruleFieldDTO
	 */
	void insertRuleField(@Param("ruleField")RuleFieldDTO ruleFieldDTO);

	/**
	 * 
	* @Description:（添加规则字典） 
	* 方法返回值: @param ruleDicList
	 */
	void insertRuleFieldDicList(@Param("ruleDicList")List<RuleFieldDicDTO> ruleDicList);

}
