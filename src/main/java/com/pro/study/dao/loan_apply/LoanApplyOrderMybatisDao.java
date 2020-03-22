package com.pro.study.dao.loan_apply;

import org.apache.ibatis.annotations.Param;

import com.pro.study.dto.loanApply.LoanApplyOrderDTO;

/**
 * 
* @author: wgl
* @date: 2020年3月20日下午6:47:07 
* @version:1.0
* @Description:贷款申请人订单数据层
 */

public interface LoanApplyOrderMybatisDao {
	/**
	 * 
	* @param order 
	 * @Description:（添加贷款订单） 
	* 方法返回值: @return
	 */
	public Long insertLoanOrder(@Param("order")LoanApplyOrderDTO order);
	
}