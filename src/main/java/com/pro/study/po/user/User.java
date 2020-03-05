package com.pro.study.po.user;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年2月23日下午3:38:12 
* @version:1.0
* @Description: 用户数据库实体类
*/
@Entity
@Data
@Table(name = "pro_user")
@org.hibernate.annotations.Table(appliesTo = "pro_user",comment = "用户表")
public class User extends BasePojo{
	
	/**
	 * 用户姓名
	 */
	@Column(name = "role_id",nullable=false,columnDefinition="bigint(255) COMMENT '角色id'")
	private Long roleId;
	
	/**
	 * 用户姓名
	 */
	@Column(name = "name",nullable=false,columnDefinition="varchar(50) COMMENT '姓名'")
	private String name;
	
	/**
	 * 用户名
	 */
	@Column(name = "username",unique = true,nullable=false,columnDefinition="varchar(255) COMMENT '用户名'")
	private String username;
	
	/**
	 * 用户密码
	 */
	@Column(name = "password",nullable=false,columnDefinition="varchar(255) COMMENT '密码'")
	private String password;

	/**
	 * 身份证号
	 */
	@Column(name = "id_card",unique = true,nullable=false,columnDefinition="varchar(255) COMMENT '身份证号'")
	private String idCard;
	
	/**
	 * 邮箱
	 */
	@Column(name = "email",nullable=false,columnDefinition="varchar(255) COMMENT '邮箱'")
	private String email;
	
	/**
	 * 手机号
	 */
	@Column(name = "phone_number",nullable=false,columnDefinition="varchar(255) COMMENT '手机号'")
	private String phoneNumber;
	
	/**
	 * 公司id
	 */
	@Column(name = "company_id",columnDefinition="bigint(255) COMMENT '公司id'")
	private Long companyId;
}
