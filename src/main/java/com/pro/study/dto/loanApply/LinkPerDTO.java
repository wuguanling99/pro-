package com.pro.study.dto.loanApply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月21日下午7:38:53 
* @version:1.0
* @Description: 联系人数据介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkPerDTO {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 手机号
	 */
	private String phoneNumber;
	
	/**
	 * 关系
	 */
	private Integer relationship;
	
	/**
	 * 住址
	 */
	private String location;
	
	/**
	 * 订单id
	 */
	private Long orderId;
}
