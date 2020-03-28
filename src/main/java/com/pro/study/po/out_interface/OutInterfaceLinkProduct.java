package com.pro.study.po.out_interface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pro.study.po.BasePojo;

import lombok.Data;

/**
 * 
* @author: wgl
* @date: 2020年3月28日上午4:36:58 
* @version:1.0
* @Description:外部数据接口和产品管理表
 */
@Data
@Entity
@Table(name = "interface_product_link")
@org.hibernate.annotations.Table(appliesTo = "interface_product_link",comment = "外部数据接口和产品管理表")
public class OutInterfaceLinkProduct extends BasePojo{

	/**
	 * 接口id
	 */
	@Column(name = "interface_id",columnDefinition="bigint(255) COMMENT '接口id'")
	private Long interfaceId;
	
	/**
	 * 产品id
	 */
	@Column(name = "product_id",columnDefinition="bigint(255) COMMENT '产品id'")
	private Long productId;
	
	/**
	 * 节点Id
	 */
	@Column(name = "node_id",columnDefinition="bigint(255) COMMENT '节点id'")
	private Long nodeId;
	
}
