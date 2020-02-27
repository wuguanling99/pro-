package com.pro.study.service.user;

import com.pro.study.vo.user.LoginResponseVO;
import com.pro.study.vo.user.UserLoginVO;

/** 
* @author: wgl
* @date: 2020年2月26日下午11:05:40 
* @version:1.0
* @Description: 用户业务层
*/
public interface UserService {

	LoginResponseVO login(UserLoginVO loginVo);

}
