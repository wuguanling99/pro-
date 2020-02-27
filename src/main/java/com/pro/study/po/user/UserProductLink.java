package com.pro.study.po.user;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.pro.study.enums.SysDicEnum;

/**
 * 
* @author: wgl
* @date: 2020年2月27日下午12:29:41 
* @version:1.0
* @Description:用户产品中间表
 */
@Table(name = "user_product_link")
@org.hibernate.annotations.Table(appliesTo = "user_product_link",comment = "用户产品关联表")
public class UserProductLink {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	
}
