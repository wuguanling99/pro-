package com.pro.study.dto.loanApply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月20日下午7:03:35 
* @version:1.0
* @Description:贷款申请表个人基本信息数据介质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerInfoDTO {
	/**
	 * 申请人姓名
	 */
	private String name;
	/**
	 * 申请金额
	 */
	private Integer amount;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 受教育程度
	 */
	private Integer edu;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 身份证反面照
	 */
	private String downImage;
	/**
	 * 正面照
	 */
	private String upImage;
	/**
	 * 婚姻信息
	 */
	private Integer marryInfo;
	/**
	 * 籍贯--区
	 */
	private String area;
	/**
	 * 籍贯--城市
	 */
	private String city;
	/**
	 * 籍贯--省
	 */
	private String province;
	/**
	 * 身份证居住地
	 */
	private String idCardLocation;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 手机号
	 */
	private String phoneNumber;
	/**
	 * 邮编
	 */
	private String postalCode;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 社保号
	 */
	private String socialNum;
	/**
	 * 供养人数
	 */
	private Integer supportNum;
	/**
	 * 微信号
	 */
	private String wechatCode;
	/**
	 * 居住地址
	 */
	private String location;
}
