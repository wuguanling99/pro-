package com.pro.study.service.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RoleService {

	/**
	 * 
	* @Description:（获取所有的接口对应的url和权限） 
	* 方法返回值: @return
	 */
	Map<String, List<String>> getAllRoleAndUrlAuth();
	
	/**
	 * 
	* @Description:（获取所有需要解密的url） 
	* 方法返回值: @return
	 */
	List<String> getNeedDecryPermitUrls();
	
	/**
	 * 
	* @Description:（获取所有不需要解密的url） 
	* 方法返回值: @return
	 */
	List<String> getDontNeedDecryPermitUrls();


}
