package com.pro.study.po.loan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月10日下午3:37:53 
* @version:1.0
* @Description: 贷款申请表信用卡信息
*/
@Entity
@Data
@Table(name = "loan_applicant_credit_card_info")
@org.hibernate.annotations.Table(appliesTo = "loan_applicant_credit_card_info",comment = "贷款申请表信用卡信息")
public class LoanApplicantCreditCardInfo extends BasePojo{
	
	/**
	 * 订单Id
	 */
	@Column(name = "order_id",nullable=false,columnDefinition="bigint(255) COMMENT '订单id'")
	private Long orderId;
	
	/**
	 * 信用卡卡号
	 */
	@Column(name = "bank_card_code",nullable=false,columnDefinition="varchar(255) COMMENT '信用卡卡号'")
	private Integer creditCardCode;
	
	/**
	 * 信用卡开户行
	 */
	@Column(name = "bankName",nullable=false,columnDefinition="varchar(255) COMMENT '信用卡对应开户行'")
	private String creditName;
	
	/**
	 * 信用卡卡号
	 */
	@Column(name = "bank_card_up_image",nullable=false,columnDefinition="varchar(255) COMMENT '信用卡正面url'")
	private String creditCardUpImage;

	/**
	 * 信用卡反面
	 */
	@Column(name = "bank_card_down_image",nullable=false,columnDefinition="varchar(255) COMMENT '信用卡反面url'")
	private String creditCardDownImage;
}
