package com.pro.study.vo.response.sys;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data	
public class SysListResponseVO<T> {
	/**
	 * 返回码
	 */
	private Integer code;
	
	/**
	 * 消息
	 */
	private String message;
	
	/**
	 * 数据
	 */
	private List<T> data;
}
