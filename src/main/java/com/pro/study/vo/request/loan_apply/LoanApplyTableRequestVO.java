package com.pro.study.vo.request.loan_apply;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月4日上午12:09:54 
* @version:1.0
* @Description: 贷款申请表请求vo
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplyTableRequestVO {

	/**
	 * 申请人姓名
	 */
	private String applicantName;
	
	/**
	 * 性别
	 */
	private Integer sex;
	
	/**
	 * 身份证号
	 */
	private String idCard;
	
	
	/**
	 * 身份证居住地址
	 */
	private String idCardLocation;
	
	/**
	 * 现据地
	 */
	private String nowLocation;
	
	
	/**
	 * 婚姻信息
	 */
	private Integer marryInfo;
	
	
	/**
	 * 邮政编码
	 */
	private String postalCode;


	/**
	 * 供养人数
	 */
	private Integer supportNum;
	
	
	/**
	 * 教育程度
	 */
	private Integer edu;
	
	/**
	 * 住房类型
	 */
	private Integer houseType;


	/**
	 * 手机号
	 */
	private String phoneNum;
	
	
	/**
	 * email
	 */
	private String eMail;

	/**
	 * 籍贯省
	 */
	private String nativeProvince;
	
	/**
	 * 籍贯市
	 */
	private String nativeCity;
	
	/**
	 * 籍贯区
	 */
	private String nativeArea;
	
	/**
	 * 社保号
	 */
	private String socialNum;
}
