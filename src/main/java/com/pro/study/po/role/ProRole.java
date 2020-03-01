package com.pro.study.po.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年2月27日下午9:53:03 
* @version:1.0
* @Description: 角色表
*/
@Entity
@Data
@Table(name = "pro_role")
@org.hibernate.annotations.Table(appliesTo = "pro_role",comment = "角色表")
@AllArgsConstructor
@NoArgsConstructor
public class ProRole extends BasePojo{

	@Column(name = "role_name",nullable=false,columnDefinition="varchar(255) COMMENT '角色名'")
	private String roleName;
	
	@Column(name = "role_describe",nullable=false,columnDefinition="varchar(255) COMMENT '角色描述'")
	private String roleDescribe;
}
