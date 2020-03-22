package com.pro.study.dao.role;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pro.study.po.role.Menu;

/**
 * 
* @author: wgl
* @date: 2020年3月18日下午11:36:18 
* @version:1.0
* @Description:目录数据层
 */
@Repository
public interface MenuMybatisDao {
	
	/**
	 * 
	* @Description:（添加用户） 
	* 方法返回值: @param homeMenu
	 */
	Long insertMenu(@Param("menu")Menu homeMenu);

}
