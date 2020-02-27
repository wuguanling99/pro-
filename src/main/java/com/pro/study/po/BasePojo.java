package com.pro.study.po;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.pro.study.enums.SysDicEnum;

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
public class BasePojo {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition="bigint(255) COMMENT '主键id,主键自增'")
	private Long id;
	
	/**
	 * 数据创建时间
	 */
    @CreatedDate
    @Column(name = "create_time",nullable=false,columnDefinition="datetime COMMENT '数据创建时间'")
	private DateTime createTime;
	
	/**
	 * 数据修改时间
	 */
    @LastModifiedDate
    @Column(name = "update_time",nullable=false,columnDefinition="datetime COMMENT '数据最后更新时间'")
	private DateTime updateTime;
	
	/**
	 * 删除标志位默认是未删除（有效）  0:删除 1:有效
	 */
    @NotBlank(message = "系统字段不能为空")
    @Column(name = "delete_flag",nullable=false,columnDefinition="int(1)  COMMENT '假删除标识0:删除 1:有效'")
    private Integer deleteFlag=SysDicEnum.SYS_VALID.getCode();

}