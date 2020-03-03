package com.pro.study.dao.role;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.role.Menu;
/**
 * 
* @author: wgl
* @date: 2020年2月29日上午1:55:52 
* @version:1.0
* @Description: roleDao数据接口层
 */
public interface MenuRepository extends JpaSpecificationExecutor<Menu>, CrudRepository<Menu, Long> {

	
	/**
	 * 
	* @Description:（根据角色查询出所有有效的目录） 
	* 方法返回值: @param roleId
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	List<Menu> findByRoleIdAndDeleteFlag(Long roleId, Integer code);


}
