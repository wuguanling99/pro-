package com.pro.study.serviceimpl.user;

import org.springframework.stereotype.Service;

import com.pro.study.service.user.UserService;
import com.pro.study.vo.user.LoginResponseVO;
import com.pro.study.vo.user.UserLoginVO;

/** 
* @author: wgl
* @date: 2020年2月26日下午11:06:54 
* @version:1.0
* @Description: 用户业务层
*/
@Service
public class UserServiceImpl implements UserService {
	
	
	/**
	 * 将用户传过来的用户类和数据库的数据进行对比密码需要用Base64转码
	 */
	@Override
	public LoginResponseVO login(UserLoginVO loginVo) {
		String password = loginVo.getPassword();
		String username = loginVo.getUsername();
		return null;
	}

}
