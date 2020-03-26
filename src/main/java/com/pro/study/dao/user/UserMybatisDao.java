package com.pro.study.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pro.study.dto.sys.LimitDto;
import com.pro.study.dto.user.CheckUserDTO;
import com.pro.study.dto.user.UserBaseInfoDTO;
import com.pro.study.po.role.ProAuth;
import com.pro.study.vo.request.user.UserBaseInfoRequestVO;
import com.pro.study.vo.response.user.CheckUserListReponseVO;

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
	
	/**
	 * 
	* @param roleId 
	 * @Description:（分页获取审核员） 
	* 方法返回值: @param pageNum
	* 方法返回值: @param pageSize
	* 方法返回值: @param companyId
	* 方法返回值: @return
	 */
	List<CheckUserListReponseVO> getCheckUserList(@Param("page")LimitDto limit,@Param("companyId") Long companyId,@Param("roleId") Long roleId);
	
	/**
	 * 
	* @Description:（根据角色名查询角色id） 
	* 方法返回值: @param role
	* 方法返回值: @return
	 */
	Long findAuthIdByName(@Param("roleName")String role);
	
	/**
	 * 
	* @Description:（获取该角色下所有用户数） 
	* 方法返回值: @param roleId
	* 方法返回值: @return
	 */
	Integer selectUserTotalByRoleId(@Param("roleId")Long roleId);
	
	/**
	 * 
	* @Description:（修改审核人信息） 
	* 方法返回值: @param checkUserDTO
	 */
	void updateCheckUserInfo(@Param("checkUser")CheckUserDTO checkUserDTO);

}
