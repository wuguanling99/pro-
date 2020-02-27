package com.pro.study.po.company;

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
* @date: 2020年2月27日上午2:26:45 
* @version:1.0
* @Description: 公司产品中间表
*/
@Data
@Entity
@Table(name = "company_product_link")
@org.hibernate.annotations.Table(appliesTo = "company_product_link",comment = "公司产品关联表")
public class CompanyProductLink extends BasePojo{
	
	/**
	 * 公司ID
	 */
	@Column(name = "company_id",nullable=false,columnDefinition="bigint(255) COMMENT '公司id'")
	private Long companyId;
	
	/**
	 * 产品ID
	 */
	@Column(name = "product_id",nullable=false,columnDefinition="bigint(255) COMMENT '产品id'")
	private Long productId;
	
}
