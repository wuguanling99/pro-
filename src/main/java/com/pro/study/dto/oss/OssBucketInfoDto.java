package com.pro.study.dto.oss;

import java.util.Date;

import com.aliyun.oss.model.Owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月6日上午1:14:53 
* @version:1.0
* @Description: ossBucket数据介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OssBucketInfoDto {
	
	/**
	 * 
	 */
	private String bucketName;
	
	/**
	 * 
	 */
	private String location;
	
	/**
	 * 
	 */
	private Date createDate;
	
	/**
	 * 
	 */
	private Owner owner;

}
