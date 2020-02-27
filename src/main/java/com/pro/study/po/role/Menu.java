package com.pro.study.po.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年2月27日下午11:01:03 
* @version:1.0
* @Description: 目录实体
*/
@Data
@Entity
@Table(name = "menu")
@org.hibernate.annotations.Table(appliesTo = "menu",comment = "目录表")
public class Menu extends BasePojo{
	
	@Column(name = "pid",nullable=false,columnDefinition="bigint(255) COMMENT '子父节点标识'")
	private Long pid;
	
	@Column(name = "menu_name",nullable=false,columnDefinition="varchar(255) COMMENT '目录名'")
	private String menuName;
	
	@Column(name = "menu_url",nullable=false,columnDefinition="varchar(255) COMMENT '目录对应接口'")
	private String menuUrl;
	
	@Column(name = "role_id",nullable=false,columnDefinition="bigint(255) COMMENT '角色id'")
	private Long roleId;

}
