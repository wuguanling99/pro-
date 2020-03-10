package com.pro.study.vo.request.loan_apply;

import javax.persistence.Column;

/** 
* @author: wgl
* @date: 2020年3月10日下午7:04:47 
* @version:1.0
* @Description: 联系人信息
*/
public class LinkPerInfo {
	/**
	 * 联系人姓名
	 */
	private String linkPerName;
	
	/**
	 *联系人手机号
	 */
	private String linkPerPhoneNumber;
	
	/**
	 * 联系人住址
	 */
	private String linkPerLocation;

	/**
	 * 联系人与申请人关系
	 */
	private Integer linkPerType;
}
