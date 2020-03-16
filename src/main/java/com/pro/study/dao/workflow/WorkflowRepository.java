package com.pro.study.dao.workflow;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.product.Product;
import com.pro.study.po.workflow.ProWorkFlow;

/** 
* @author: wgl
* @date: 2020年3月15日上午2:15:50 
* @version:1.0
* @Description: 工作流数据层
*/
public interface WorkflowRepository extends JpaSpecificationExecutor<ProWorkFlow>, CrudRepository<ProWorkFlow, Long> {

}
