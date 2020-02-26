package com.pro.study.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年2月23日下午11:09:48 
* @version:1.0
* @Description: 用户登录用类
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVO {
	
	private String username;
	
	private String password;

}
