package com.pro.study.dao.loan_apply;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.loan.LoanApplicantCreditCardInfo;

/** 
* @author: wgl
* @date: 2020年3月10日下午7:54:38 
* @version:1.0
* @Description: 贷款信用卡信息
*/
public interface LoanCreditCardRepository extends JpaSpecificationExecutor<LoanApplicantCreditCardInfo>, CrudRepository<LoanApplicantCreditCardInfo, Long> {

}