package com.pro.study.utils;
/**
 * 
* @author: wgl
* @date: 2020年3月3日下午9:00:02 
* @version:1.0
* @Description:数据脱敏工具类
 */
public class ETLUtil {
	
	/**
	 * 
	* @Description:（手机号脱敏） 
	* 方法返回值: @param phoneNumber
	 */
	public static String etlPhoneNumber(String phoneNumber) {
		return phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(7, phoneNumber.length());
	}
	
	/**
	 * 
	* @Description:（身份证号脱敏） 
	* 方法返回值: @param idCard
	* 方法返回值: @return
	 */
	public static String etlIdCard(String idCard) {
		return idCard.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
	}
	
	/**
	 * 
	* @Description:（判断是否是数据清洗后的数据）
	* 方法返回值: @param phoneNumber
	* 方法返回值: @return
	 */
	public static boolean isETLPhoneNumber(String phoneNumber) {
		return phoneNumber.contains("****") ? true:false;
	}
	
}