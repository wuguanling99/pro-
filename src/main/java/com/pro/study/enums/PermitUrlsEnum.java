package com.pro.study.enums;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
* @author: wgl
* @date: 2020年2月23日下午9:51:34 
* @version:1.0
* @Description: 所有可以放行的url枚举类
*/
@Getter
@AllArgsConstructor
public enum PermitUrlsEnum {
	GET_RSA_KEY("/key/getRSAKey"),
	POST_LOGIN("/user/login"),
	GET_CHECK_CODE("/user/createValidateCode"),
	POST_CREATE_USER("/user/createUser"),
	;
	private String urls;
	
	//构造一个静态资源用来保存所有的URL
	private static List<String>  passUrlList = new ArrayList<String>();
	
	//构造一个静态资源用来保存所有的不需要验证且需要解密的url
	private static List<String>  passUrlAndNeedDecryptList = new ArrayList<String>();
	
	//构造一个静态资源用来保存所有的需要解密的url
	private static List<String>  needDecryPermitList = new ArrayList<String>();
	
	static {
		//添加不需要认证的接口url
		passUrlList.add(GET_RSA_KEY.getUrls());
		passUrlList.add(POST_LOGIN.getUrls());
		passUrlList.add(GET_CHECK_CODE.getUrls());
		passUrlList.add(POST_CREATE_USER.getUrls());
		//添加不需要认证 但是需要解密的url
		passUrlAndNeedDecryptList.add(POST_CREATE_USER.getUrls());
		//添加需要解密的url
		needDecryPermitList.add(POST_CREATE_USER.getUrls());
	}
	
	/**
	 * 
	* @Description:（判断传入的url是否在允许不用校验权限的范围内） 
	* 方法返回值: @param url 在范围内
	* 方法返回值: @return true 在范围内  false不在允许通过的范围内
	 */
	public static boolean hasPermitUrls(String url) {
		if(ArrayUtils.contains(passUrlList.toArray(), url)) {
			//证明该url不需要身份认证
			return true;
		}else {
			//证明该url需要身份认证
			return false;
		}
	}
	
	/**
	* @Description:（判断传入的url是否在允许不用校验权限的范围内且需要解码） 
	* 方法返回值: @param url 在范围内
	* 方法返回值: @return true 在范围内  false不在允许通过的范围内
	 */
	public static boolean hasPermitUrlAndNeedRsaDecrypt(String url) {
		if(ArrayUtils.contains(passUrlAndNeedDecryptList.toArray(), url)) {
			//证明该url不需要身份认证且需要RSA解码
			return true;
		}else {
			//证明该url需要身份认证
			return false;
		}
	}
	
	/**
	 * 
	* @Description:（是否是需要解密的url） 
	* 方法返回值: @param url
	* 方法返回值: @return
	 */
	public static boolean hasNeedDecryPermitUrls(String url) {
		if(ArrayUtils.contains(needDecryPermitList.toArray(), url)) {
			return true;
		}else {
			return false;
		}
	}

}
