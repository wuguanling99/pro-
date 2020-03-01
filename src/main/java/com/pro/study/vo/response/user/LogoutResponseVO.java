package com.pro.study.vo.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月2日上午2:59:47 
* @version:1.0
* @Description: 登出VO类
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoutResponseVO {
	private Integer code;
	private String message;
}
