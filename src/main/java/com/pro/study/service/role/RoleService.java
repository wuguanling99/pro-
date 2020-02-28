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
	Set<Map<String, List<String>>> getAllRoleAndUrlAuth();


}
