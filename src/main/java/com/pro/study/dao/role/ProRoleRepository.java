package com.pro.study.dao.role;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.role.ProRole;
import com.pro.study.po.user.User;
/**
 * 
* @author: wgl
* @date: 2020年2月29日上午1:55:52 
* @version:1.0
* @Description: roleDao数据接口层
 */
public interface ProRoleRepository extends JpaSpecificationExecutor<ProRole>, CrudRepository<ProRole, Long> {

	/**
	 * 
	* @Description:（根据系统删除字段查询角色） 
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	List<ProRole> findByDeleteFlag(Integer code);

	/**
	 * 
	* @Description:（根据角色名查询出角色对应额角色对象） 
	* 方法返回值: @param role
	* 方法返回值: @return
	 */
	ProRole findByRoleName(String role);


}
