package com.pro.study.vo.response.loan_apply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月5日下午11:30:54 
* @version:1.0
* @Description:上传图片返回对象 
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponseVO {
	
	/**
	 * 编码
	 */
	private Integer code ;
	
	/**
	 * 图片Url
	 */
	private String imageUrl;

}
