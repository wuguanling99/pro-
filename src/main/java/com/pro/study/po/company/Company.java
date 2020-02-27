package com.pro.study.po.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年2月27日下午10:26:49 
* @version:1.0
* @Description: 公司表
*/
@Data
@Entity
@Table(name = "company")
@org.hibernate.annotations.Table(appliesTo = "company",comment = "产品表")
public class Company extends BasePojo{
	
	@Column(name = "company_name",nullable=false,columnDefinition="varchar(255) COMMENT '公司名'")
	private String companyName;
	
	@Column(name = "company_describe",nullable=false,columnDefinition="varchar(255) COMMENT '公司描述'")
	private String companyDescribe;
	
	@Column(name = "company_email",nullable=false,columnDefinition="varchar(255) COMMENT '公司邮箱'")
	private String companyEmail;
	
	@Column(name = "company_telephone",nullable=false,columnDefinition="varchar(255) COMMENT '公司固定电话'")
	private String companyTelephone;
	
	@Column(name = "company_url",nullable=false,columnDefinition="varchar(255) COMMENT '公司官网'")
	private String companyUrl;
	
	@Column(name = "company_location",nullable=false,columnDefinition="varchar(255) COMMENT '公司住址'")
	private String companyLocation;
}