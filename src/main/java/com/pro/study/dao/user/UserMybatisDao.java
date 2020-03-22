package com.pro.study.dao.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pro.study.dto.user.UserBaseInfoDTO;
import com.pro.study.po.role.ProAuth;
import com.pro.study.vo.request.user.UserBaseInfoRequestVO;

/**
 * 
* @author: wgl
* @date: 2020年3月18日上午3:35:31 
* @version:1.0
* @Description:用户mybatis数据接口
 */
@Repository
public interface UserMybatisDao {

	/**
	 * 
	* @Description:（添加用户） 
	* 方法返回值: @param user
	 */
	void insertUser(@Param("user")ProAuth user);
	
	/**
	 * 
	* @Description:（获取用户基本信息） 
	* 方法返回值: @param userId
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	UserBaseInfoDTO findUser(@Param("userId")Long userId,@Param("deleteFlag") Integer deleteFlag);
	
	/**
	 * 
	* @Description:（修改个人基本信息） 
	* 方法返回值: @param userBaseInfo
	* 方法返回值: @param userId
	 */
	void updateUserInfo(@Param("user")UserBaseInfoRequestVO userBaseInfo);

}
