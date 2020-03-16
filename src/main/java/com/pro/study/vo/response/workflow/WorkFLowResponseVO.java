package com.pro.study.vo.response.workflow;

import com.pro.study.enums.SysDicEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月11日下午5:35:37 
* @version:1.0
* @Description: 工作流返回对象
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkFLowResponseVO {
	
	private String name;
	
	private Integer code;
	
	private String message;
	
	
	
	/**
	 * 
	* @Description:（调用成功创建流程引擎的方法） 
	* 方法返回值: @param name
	* 方法返回值: @return
	 */
	public WorkFLowResponseVO success(String name) {
		return new WorkFLowResponseVO(name,SysDicEnum.SUCCESS.getCode(),name+"流程引擎创建成功");
	}

	/**
	 * 
	* @Description:（调用失败创建流程引擎的方法） 
	* 方法返回值: @return
	 */
	public WorkFLowResponseVO faild() {
		return new WorkFLowResponseVO(SysDicEnum.ERROR.getCode(),"流程引擎创建失败");
	}

	public WorkFLowResponseVO(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}
