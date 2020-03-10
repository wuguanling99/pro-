package com.pro.study.dao.loan_apply;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.loan.LoanApplicantBankCardInfo;

/** 
* @author: wgl
* @date: 2020年3月10日下午7:53:15 
* @version:1.0
* @Description: 贷款申请表银行卡信息
*/
public interface LoanBankInfoRepository extends JpaSpecificationExecutor<LoanApplicantBankCardInfo>, CrudRepository<LoanApplicantBankCardInfo, Long> {

}