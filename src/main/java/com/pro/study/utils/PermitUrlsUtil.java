package com.pro.study.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pro.study.service.role.RoleService;

/** 
* @author: wgl
* @date: 2020年2月23日下午9:51:34 
* @version:1.0
* @Description: 所有可以放行的url枚举类
*/
@Component
public class PermitUrlsUtil {
	
	
	@Autowired
	private static RoleService roleService;
	
	public static RoleService getRoleService() {
		return roleService;
	}
	@Autowired(required=false)
	public void setTorganRelationService(
		@Qualifier("roleService")RoleService roleService) {
		PermitUrlsUtil.roleService = roleService;
	}
	
	
	//不需要权限认证可以直接放行的接口
	private static Set<String>  passUrlList = new HashSet<String>();
	
	//角色set可以访问的接口---查询出数据库里所有的角色保存在这里
	private Set<Map<String,List<String>>> roleUrlSet = new HashSet<Map<String,List<String>>>();
	
	//不需要解密的url
	private static List<String>  dontNeedDecryptList = new ArrayList<String>();
	
	//需要解密的url
	private static List<String>  needDecryPermitList = new ArrayList<String>();
	
	
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
	
	/**
	 * 
	* @Description:（是否是不需要解密的url） 
	* 方法返回值: @param url
	* 方法返回值: @return
	 */
	public static boolean hasDontNeedDecryPermitUrls(String url) {
		if(ArrayUtils.contains(dontNeedDecryptList.toArray(), url)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	* @Description:（是否是不可以直接放行的url） 
	* 方法返回值: @param url
	* 方法返回值: @return
	 */
	public static boolean hasPassUrls(String url) {
		if(ArrayUtils.contains(passUrlList.toArray(), url)) {
			return true;
		}else {
			return false;
		}
	}
	

	/**
	 * 
	 * @Description:（接口用户权限认证,最后把用户放到request里） 
	 * 方法返回值: @param requestURI
	 * 方法返回值: @param token
	 * 方法返回值: @return
	 */
	public static boolean authCheck(String requestURI, String token, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
    public static void init() { 
		Set<Map<String,List<String>>> roleSet = roleService.getAllRoleAndUrlAuth();
    } 
}
