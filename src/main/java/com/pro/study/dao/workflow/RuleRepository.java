package com.pro.study.dao.workflow;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.workflow.Rule;

/** 
* @author: wgl
* @date: 2020年3月26日下午7:23:00 
* @version:1.0
* @Description: 规则数据层
*/
public interface RuleRepository extends JpaSpecificationExecutor<Rule>, CrudRepository<Rule, Long> {
	
	/**
	 * 
	* @Description:（根据id查询对应的规则） 
	* 方法返回值: @param id
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	Rule findByIdAndDeleteFlag(Long id, Integer code);
	

}
