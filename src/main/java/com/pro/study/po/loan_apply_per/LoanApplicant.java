package com.pro.study.po.loan_apply_per;

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
* @date: 2020年2月23日下午1:38:12 
* @version:1.0
* @Description: 贷款申请人实体类
*/
@Entity
@Data
public class LoanApplicant{
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 订单Id
	 */
	private Long orderId;
	
	/**
	 * 申请人姓名
	 */
	@NotBlank(message = "申请人姓名不能为空")
	private String applicantName;
	
	/**
	 * 性别
	 */
	@NotBlank(message = "性别不能为空")
	private Integer sex;
	
	/**
	 * 身份证号
	 */
	@NotBlank(message = "身份证号不能为空")
	private String idCard;
	
	
	/**
	 * 身份证居住地址
	 */
	@NotBlank(message = "身份证居住地址不能为空")
	private String idCardLocation;
	
	
	/**
	 * 婚姻信息
	 */
	@NotBlank(message = "婚姻信息不能为空")
	private Integer marryInfo;
	
	
	/**
	 * 邮政编码
	 */
	@NotBlank(message = "邮编不能为空")
	private String postalCode;


	/**
	 * 供养人数
	 */
	@NotBlank(message = "供养人数不能为空")
	private Integer supportNum;
	
	
	/**
	 * 教育程度
	 */
	@NotBlank(message = "教育程度不能为空")
	private Integer edu;


	/**
	 * 手机号
	 */
	@NotBlank(message = "手机号不能为空")
	private String phoneNum;
	
	
	/**
	 * email
	 */
	@NotBlank(message = "邮箱")
	private String eMailNum;

	/**
	 * 籍贯省
	 */
	@NotBlank(message = "省不能为空")
	private String nativeProvince;
	
	/**
	 * 籍贯市
	 */
	@NotBlank(message = "市不能为空")
	private String nativeCity;
	
	/**
	 * 籍贯区
	 */
	@NotBlank(message = "区不能为空")
	private String nativeArea;
	
	/**
	 * 社保号
	 */
	@NotBlank(message = "社保号不能为空")
	private String socialNum;

	
	/**
	 * 房屋类型
	 */
	@NotBlank(message = "房屋类型不能为空")
	private Integer houseType;
	
	
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