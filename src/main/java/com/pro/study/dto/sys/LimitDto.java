package com.pro.study.dto.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitDto {

	/**
	 * 开始limit
	 */
	private Integer limitStart;
	
	/**
	 * 结束limit
	 */
	private Integer limitEnd;
}
