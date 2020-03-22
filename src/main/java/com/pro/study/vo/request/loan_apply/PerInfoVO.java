package com.pro.study.vo.request.loan_apply;

import lombok.Data;

/**
 * 
* @author: wgl
* @date: 2020年3月10日下午5:45:29 
* @version:1.0
* @Description:贷款申请表个人基本信息
 */
@Data
public class PerInfoVO {

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
	
	/**
	 * 身份证正面照
	 */
	private String upImage;
	
	/**
	 * 身份证反面照
	 */
	private String downImage;
	
	/**
	 * 微信号
	 */
	private String weChatCode;
}
