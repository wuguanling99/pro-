package com.pro.study.po;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年2月27日下午11:28:07 
* @version:1.0
* @Description: 基础表 抽取公共部分字段
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePojo implements Serializable {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition="bigint(255) COMMENT '主键id,主键自增'")
	protected Long id;
	
	/**
	 * 数据创建时间
	 */
    @Column(name = "create_time",insertable = false,nullable=false,columnDefinition="datetime default CURRENT_TIMESTAMP COMMENT '数据创建时间'")
	private Timestamp createTime;
	
	/**
	 * 数据修改时间
	 */
    @Column(name = "update_time",nullable=false,insertable = false,columnDefinition="datetime  default CURRENT_TIMESTAMP COMMENT '数据最后更新时间'")
	private Timestamp updateTime;
	
	/**
	 * 删除标志位默认是未删除（有效）  0:删除 1:有效
	 */
    @Column(name = "delete_flag",insertable = false,nullable=false,columnDefinition="int(1) default 0 COMMENT '假删除标识0:删除 1:有效'")
    private Integer deleteFlag;

}
