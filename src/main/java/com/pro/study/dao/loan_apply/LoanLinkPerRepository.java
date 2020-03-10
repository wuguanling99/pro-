package com.pro.study.dao.loan_apply;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.loan.LoanApplicantLinkInfo;

/** 
* @author: wgl
* @date: 2020年3月10日下午7:56:54 
* @version:1.0
* @Description: 贷款申请联系人信息
*/
public interface LoanLinkPerRepository extends JpaSpecificationExecutor<LoanApplicantLinkInfo>, CrudRepository<LoanApplicantLinkInfo, Long> {

}
