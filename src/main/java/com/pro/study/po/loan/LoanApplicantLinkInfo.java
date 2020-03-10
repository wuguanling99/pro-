package com.pro.study.po.loan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年3月10日下午3:43:21 
* @version:1.0
* @Description: 贷款申请表联系人信息
*/
@Data
@Entity
@Table(name = "loan_applicant_link_info")
@org.hibernate.annotations.Table(appliesTo = "loan_applicant_link_info",comment = "贷款订单表联系人信息")
public class LoanApplicantLinkInfo extends BasePojo{
	/**
	 * 订单Id
	 */
	@Column(name = "order_id",nullable=false,columnDefinition="bigint(255) COMMENT '订单id'")
	private Long orderId;
	
	/**
	 * 联系人姓名
	 */
	@Column(name = "link_per_name",nullable=false,columnDefinition="varchar(50) COMMENT '联系人姓名'")
	private String linkPerName;
	
	/**
	 *联系人手机号
	 */
	@Column(name = "link_per_phone_number",nullable=false,columnDefinition="varchar(255) COMMENT '联系人手机号'")
	private String linkPerPhoneNumber;
	
	/**
	 * 联系人住址
	 */
	@Column(name = "link_per_location",nullable=false,columnDefinition="varchar(255) COMMENT '联系人住址'")
	private String linkPerLocation;

	/**
	 * 联系人与申请人关系
	 */
	@Column(name = "link_per_type",nullable=false,columnDefinition="int(1) COMMENT '联系人与申请人关系'")
	private Integer linkPerType;
}
