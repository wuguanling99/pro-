package com.pro.study.po.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.pro.study.enums.SysDicEnum;
import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年2月23日下午3:38:12 
* @version:1.0
* @Description: 用户数据库实体类
*/
@Data
@Entity
@Table(name = "product")
@org.hibernate.annotations.Table(appliesTo = "product",comment = "产品表")
public class Product extends BasePojo{
	
	/**
	 * 公司id
	 */
	@Column(name = "company_id",columnDefinition="bigint(255) COMMENT '公司id对应公司表id'")
	private Long companyId;
	
	/**
	 * 产品名
	 */
	@Column(name = "company_name",unique = true,columnDefinition="varchar(255) COMMENT '产品名称'")
	private String productName;
	
	
	/**
	 * 产品描述
	 */
	@Column(name = "product_describe",columnDefinition="varchar(255) COMMENT '产品描述'")
	private String productDescribe;
	
	
}
