package com.pro.study.dao.loan_apply;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.loan.LoanApplicantPerInfo;

/** 
* @author: wgl
* @date: 2020年3月7日上午12:53:35 
* @version:1.0
* @Description: 贷款申请订单数据层
*/
public interface LoanApplicantRepository extends JpaSpecificationExecutor<LoanApplicantPerInfo>, CrudRepository<LoanApplicantPerInfo, Long> {
	
	LoanApplicantPerInfo findByOrderIdAndDeleteFlag(Long orderId,Integer flag);
	
}
