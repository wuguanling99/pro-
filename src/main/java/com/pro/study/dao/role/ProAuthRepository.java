package com.pro.study.dao.role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.role.ProAuth;

/** 
* @author: wgl
* @date: 2020年3月1日下午8:33:07 
* @version:1.0
* @Description: 权限Dao层
*/
public interface ProAuthRepository  extends JpaSpecificationExecutor<ProAuth>, CrudRepository<ProAuth, Long> {
	/**
	 * 
	* @Description:（根据删除字段查询） 
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	List<ProAuth> findByDeleteFlag(Integer code);
	
	/**
	 * 
	* @Description:（根据解密字段查询） 
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	List<ProAuth> findByDecryptFlag(Integer code);

}
