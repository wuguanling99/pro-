package com.pro.study.dto.oss;

import com.pro.study.enums.SysDicEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月6日上午1:39:24 
* @version:1.0
* @Description: 阿里云保存数据标识介质
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveObjectDto {

	private Integer saveCode;
		
	/**
	 * 
	* @Description:（判断上传是否成功） 
	* 方法返回值: @return
	 */
	public Boolean isSuccess() {
		if(this.saveCode == SysDicEnum.OSS_UPLOAD_SUCCESS.getCode()) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 根据枚举类型构造
	 * @param ossUploadSuccess
	 */
	public SaveObjectDto(SysDicEnum ossUploadSuccess) {
		this.saveCode = ossUploadSuccess.getCode();
	}
}
