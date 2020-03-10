package com.pro.study.po.loan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年2月27日下午9:46:14 
* @version:1.0
* @Description: 贷款申请订单实体
*/
@Data
@Entity
@Table(name = "loan_order")
@org.hibernate.annotations.Table(appliesTo = "loan_order",comment = "贷款订单表贷款信息")
public class LoanApplyOrder extends BasePojo{
	
	@Column(name = "user_id",nullable=false,columnDefinition="bigint(255) COMMENT '用户id'")
	private Long userId;

	@Column(name = "company_id",nullable=false,columnDefinition="bigint(255) COMMENT '公司id'")
	private Long companyId;
	
	
	@Column(name = "product_id",nullable=false,columnDefinition="bigint(255) COMMENT '产品id'")
	private Long productId;
	
	@Column(name = "order_type",nullable=false,columnDefinition="int(1) COMMENT '订单状态'")
	private Integer orderType;
	
	@Column(name = "use_type",nullable=false,columnDefinition="int(1) COMMENT '贷款用途'")
	private Integer loanUseType;
	
	@Column(name = "repayment",nullable=false,columnDefinition="int(50) COMMENT '最高接受还款金额'")
	private Integer repayment;
}
