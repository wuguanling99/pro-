package com.pro.study.po.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年2月27日下午9:54:02 
* @version:1.0
* @Description:权限表
 */
@Data
@Entity
@Table(name = "pro_auth")
@org.hibernate.annotations.Table(appliesTo = "pro_auth",comment = "权限表")
@AllArgsConstructor
@NoArgsConstructor
public class ProAuth extends BasePojo{
	

	@Column(name = "role_id",columnDefinition="bigint(255) COMMENT '角色id'")
	private Long roleId;
	
	@Column(name = "role_name",nullable=false,columnDefinition="varchar(255) COMMENT '角色名'")
	private String roleName;
	
	@Column(name = "auth_url",nullable=false,columnDefinition="varchar(255) COMMENT '角色允许访问的url'")
	private String url;
	
	@Column(name = "auth_flag",nullable=false,columnDefinition="int(1) COMMENT '是否需要认证权限的接口 0:不需要 1:需要'")
	private Integer authFlag;
	
	@Column(name = "decrypt_flag",nullable=false,columnDefinition="int(1) COMMENT '是否需要解密的接口 0:不需要 1:需要'")
	private Integer decryptFlag;
	
}
