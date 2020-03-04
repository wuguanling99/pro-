package com.pro.study.service.loan_aypply;

import javax.servlet.http.HttpServletRequest;

import com.pro.study.vo.request.loan_apply.LoanApplyTableRequestVO;
import com.pro.study.vo.response.loan_apply.CreateLoanApplyTableResponseVO;

/** 
* @author: wgl
* @date: 2020年3月3日下午5:59:06 
* @version:1.0
* @Description: 贷款申请service
*/
public interface LoanApplyService {
	
	/**
	 * 
	* @Description:（创建贷款申请表） 
	* 方法返回值: @param loanApplyTable
	* 方法返回值: @return
	 */
	CreateLoanApplyTableResponseVO createLoanApplyTable(LoanApplyTableRequestVO loanApplyTable,HttpServletRequest request);

}
