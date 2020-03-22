package com.pro.study.dao.loan_apply;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pro.study.dto.loanApply.LoanBankDTO;

/**
 * 
* @author: wgl
* @date: 2020年3月21日上午3:18:29 
* @version:1.0
* @Description: 贷款申请表银行卡信息数据层
 */
public interface LoanBankMybatisDao {
	
	/**
	 * 
	* @Description:（添加银行卡信息） 
	* 方法返回值: @param bankInfo
	 */
	void addBank(@Param("list")List<LoanBankDTO> bankInfo);

	/**
	 * 
	* @Description:（添加信用卡信息） 
	* 方法返回值: @param bankInfo
	 */
	void addCreditCard(@Param("list")List<LoanBankDTO> bankInfo);

}
