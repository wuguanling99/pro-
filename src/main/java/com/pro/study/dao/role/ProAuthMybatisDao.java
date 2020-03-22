package com.pro.study.dao.role;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pro.study.dto.role.AuthDTO;

/**
 * 
* @author: wgl
* @date: 2020年3月19日上午2:48:50 
* @version:1.0
* @Description:权限数据层
 */
@Repository
public interface ProAuthMybatisDao {

	/**
	 * 
	* @Description:（查询所有的） 
	* 方法返回值: @param decryptFlag
	* 方法返回值: @param deleteFlag
	* 方法返回值: @return
	 */
	List<AuthDTO> findByDecryptFlagAndDeleteFlag(@Param("decryptFlag")Integer decryptFlag, @Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 
	* @Description:（获取所有的接口） 
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	List<AuthDTO> findByAllUrl(@Param("deleteFlag")Integer deleteFlag);
}
