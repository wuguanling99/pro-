package com.pro.study.vo.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年2月27日上午12:58:44 
* @version:1.0
* @Description: 登陆返回的实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseVO {
	
	private Integer code;
	
	private String token;
	
	private String name;

}
