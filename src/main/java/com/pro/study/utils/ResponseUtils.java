package com.pro.study.utils;

import com.pro.study.enums.SysDicEnum;
import com.pro.study.vo.response.sys.SysResponseVO;

/**
 * 
* @author: wgl
* @date: 2020年3月1日下午5:13:52 
* @version:1.0
* @Description:返回系统功能字段的工具类
 */
public class ResponseUtils {
	
	/**
	 * 
	* @Description:（返回系统错误） 
	* 方法返回值: @return
	 */
	public static SysResponseVO returnSysError() {
		return new SysResponseVO(SysDicEnum.SYS_ERROR.getCode(),SysDicEnum.SYS_ERROR.getMessage());
	}
	
	/**
	 * 
	* @Description:（请求成功） 
	* 方法返回值: @return
	 */
	public static SysResponseVO returnSuccess() {
		return new SysResponseVO(SysDicEnum.SUCCESS.getCode(),SysDicEnum.SUCCESS.getMessage());
	}
	/**
	 * 
	* @Description:（根据传入枚举创建返回值） 
	* 方法返回值: @param sysEnum
	* 方法返回值: @return
	 */
	public static SysResponseVO createResponse(SysDicEnum sysEnum) {
		return new SysResponseVO(sysEnum.getCode(),sysEnum.getMessage());
	}
}
