package com.pro.study.service.user;

import com.pro.study.vo.request.user.CreateUserInfoVO;
import com.pro.study.vo.request.user.UserLoginVO;
import com.pro.study.vo.response.sys.SysResponseVO;
import com.pro.study.vo.response.user.LoginResponseVO;

/** 
* @author: wgl
* @date: 2020年2月26日下午11:05:40 
* @version:1.0
* @Description: 用户业务层
*/
public interface UserService {
	
	/**
	 * 
	* @Description:（登陆） 
	* 方法返回值: @param loginVo
	* 方法返回值: @return
	 */
	LoginResponseVO login(UserLoginVO loginVo)  throws Exception ;
	
	/**
	 * 
	* @Description:（创建用户） 
	* 方法返回值: @param user
	* 方法返回值: @return
	 */
	SysResponseVO createLoanApplicant(CreateUserInfoVO user);

}
