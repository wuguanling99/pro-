package com.pro.study.po.loan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月10日上午1:18:29 
* @version:1.0
* @Description: 贷款申请表
*/
@Entity
@Data
@Table(name = "loan_applicant_bankcard_info")
@org.hibernate.annotations.Table(appliesTo = "loan_applicant_bankcard_info",comment = "贷款申请表银行卡信息")
public class LoanApplicantBankCardInfo extends BasePojo{
	
	/**
	 * 订单Id
	 */
	@Column(name = "order_id",nullable=false,columnDefinition="bigint(255) COMMENT '订单id'")
	private Long orderId;
	
	/**
	 * 银行卡卡号
	 */
	@Column(name = "bank_card_code",nullable=false,columnDefinition="varchar(255) COMMENT '银行卡卡号'")
	private Integer bankCardCode;
	
	/**
	 *银行卡对应开户行'
	 */
	@Column(name = "bankName",nullable=false,columnDefinition="varchar(255) COMMENT '银行卡对应开户行'")
	private String bankName;
	
	/**
	 * 银行卡正面url
	 */
	@Column(name = "bank_card_up_image",nullable=false,columnDefinition="varchar(255) COMMENT '银行卡正面url'")
	private String bankCardUpImage;

	/**
	 * 银行卡反面url
	 */
	@Column(name = "bank_card_down_image",nullable=false,columnDefinition="varchar(255) COMMENT '银行卡反面url'")
	private String bankCardDownImage;

}

