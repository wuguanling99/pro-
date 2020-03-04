package com.pro.study.po.loan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年2月23日下午1:38:12 
* @version:1.0
* @Description: 贷款申请人实体类
*/
@Entity
@Data
@Table(name = "loan_applicant_form")
@org.hibernate.annotations.Table(appliesTo = "loan_applicant_form",comment = "贷款申请表")
public class LoanApplicant extends BasePojo{
	
	
	/**
	 * 订单Id
	 */
	@Column(name = "order_id",nullable=false,columnDefinition="bigint(255) COMMENT '订单id'")
	private Long orderId;
	
	/**
	 * 申请人姓名
	 */
	@Column(name = "applicant_name",nullable=false,columnDefinition="varchar(255) COMMENT '申请人姓名'")
	private String applicantName;
	
	/**
	 * 性别
	 */
	@Column(name = "sex",nullable=false,columnDefinition="bigint(255) COMMENT '性别'")
	private Integer sex;
	
	/**
	 * 身份证号
	 */
	@Column(name = "id_card",nullable=false,columnDefinition="varchar(255) COMMENT '身份证号'")
	private String idCard;
	
	
	/**
	 * 身份证居住地址
	 */
	@Column(name = "id_card_location",nullable=false,columnDefinition="varchar(255) COMMENT '身份证地址'")
	private String idCardLocation;
	
	/**
	 * 现居地址
	 */
	@Column(name = "now_location",nullable=false,columnDefinition="varchar(255) COMMENT '现居地址'")
	private String nowLocation;
	
	
	/**
	 * 婚姻信息
	 */
	@Column(name = "marry_info",nullable=false,columnDefinition="int(1) COMMENT '婚姻信息'")
	private Integer marryInfo;
	
	
	/**
	 * 邮政编码
	 */
	@Column(name = "postal_code",nullable=false,columnDefinition="varchar(255) COMMENT '邮编'")
	private String postalCode;


	/**
	 * 供养人数
	 */
	@Column(name = "support_num",nullable=false,columnDefinition="int(10) COMMENT '供养人数'")
	private Integer supportNum;
	
	
	/**
	 * 教育程度
	 */
	@Column(name = "edu",nullable=false,columnDefinition="int(2) COMMENT '教育程度'")
	private Integer edu;


	/**
	 * 手机号
	 */
	@Column(name = "phone_num",nullable=false,columnDefinition="varchar(255) COMMENT '手机号'")
	private String phoneNum;
	
	
	/**
	 * email
	 */
	@Column(name = "e_mail",nullable=false,columnDefinition="varchar(255) COMMENT '邮箱'")
	private String eMail;

	/**
	 * 籍贯省
	 */
	@Column(name = "native_province",nullable=false,columnDefinition="varchar(255) COMMENT '籍贯省'")
	private String nativeProvince;
	
	/**
	 * 籍贯市
	 */
	@Column(name = "native_city",nullable=false,columnDefinition="varchar(255) COMMENT '籍贯市'")
	private String nativeCity;
	
	/**
	 * 籍贯区
	 */
	@Column(name = "native_area",nullable=false,columnDefinition="varchar(255) COMMENT '籍贯区'")
	private String nativeArea;
	
	/**
	 * 社保号
	 */
	@Column(name = "social_num",nullable=false,columnDefinition="varchar(255) COMMENT '社保号'")
	private String socialNum;

}