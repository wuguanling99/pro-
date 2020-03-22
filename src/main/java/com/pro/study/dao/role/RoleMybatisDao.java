package com.pro.study.dao.role;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pro.study.dto.role.RoleDto;
import com.pro.study.po.role.ProRole;

/**
 * 
* @author: wgl
* @date: 2020年3月18日下午11:45:50 
* @version:1.0
* @Description:角色数据层
 */
@Repository
public interface RoleMybatisDao {
	/**
	 * 
	* @Description:（获取所有的角色） 
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	List<RoleDto> findAllRoleByDeleteFlag(@Param("deleteFalg")Integer code);

	/**
	 * 
	* @Description:（获取角色根据角色名和删除标志） 
	* 方法返回值: @param role
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	RoleDto findByRoleNameAndDeleteFlag(@Param("roleName")String role, @Param("deleteFalg")Integer code);
	
	
	
}
