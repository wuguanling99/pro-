package com.pro.study.dao.loan_apply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.loan.LoanApplyOrder;

/** 
* @author: wgl
* @date: 2020年3月7日上午12:53:35 
* @version:1.0
* @Description: 贷款申请订单数据层
*/
public interface LoanApplyOrderRepository extends JpaSpecificationExecutor<LoanApplyOrder>, CrudRepository<LoanApplyOrder, Long> {
	
	/**
	 * 
	* @Description:（根据用户id查询出对应的订单列表） 
	* 方法返回值: @param userId
	* 方法返回值: @return
	 */
	List<LoanApplyOrder> findByUserId(Long userId);

}
