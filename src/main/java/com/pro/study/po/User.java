package com.pro.study.po;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.pro.study.enums.SysDicEnum;

import lombok.Data;

/** 
* @author: wgl
* @date: 2020年2月23日下午3:38:12 
* @version:1.0
* @Description: 用户数据库实体类
*/
@Entity
@Data
public class User{
	
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 用户姓名
	 */
	private String name;
	
	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空")
	@Column(unique = true)
	private String username;
	
	/**
	 * 用户密码
	 */
	@NotBlank(message = "密码不能为空")
	private String password;
	
	/**
	 * 公司
	 */
	private String company;
	
	
	/**
	 * 数据创建时间
	 */
    @CreatedDate
	private DateTime createTime;
	
	/**
	 * 数据修改时间
	 */
    @LastModifiedDate
	private DateTime updateTime;
	
	/**
	 * 删除标志位默认是未删除（有效）  0:删除 1:有效
	 */
    @NotBlank(message = "系统字段不能为空")
    private Integer deleteFlag=SysDicEnum.SYS_VALID.getCode();
	
	
}
