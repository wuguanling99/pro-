package com.pro.study.vo.response.company;

import com.pro.study.enums.SysDicEnum;
import com.pro.study.vo.response.sys.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月15日上午2:30:27 
* @version:1.0
* @Description: 审核列表
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckLoanFormReponseVO {
	
	/**
	 * 请求状态
	 */
	private Integer code;
	
	/**
	 * 请求描述
	 */
	private String message;
	
	/**
	 * 列表数据
	 */
	private Page data;

	public CheckLoanFormReponseVO(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	/**
	 * 
	* @Description:（请求失败返回对象） 
	* 方法返回值:
	 */
	public static CheckLoanFormReponseVO getListFaild() {
		return new CheckLoanFormReponseVO(SysDicEnum.ERROR.getCode(),"列表数据获取失败");
	}

	/**
	 * 
	* @Description:（返回成功数据） 
	* 方法返回值: @param dicEnum
	* 方法返回值: @return
	 */
	public static CheckLoanFormReponseVO returnSucess(Page data) {
		CheckLoanFormReponseVO result = new CheckLoanFormReponseVO();
		result.setCode(SysDicEnum.SUCCESS.getCode());
		result.setData(data);
		result.setMessage("数据请求成功");
		return result;
	}
	
	/**
	* @Description:（请求失败） 
	* 方法返回值: @return
	 */
	public static CheckLoanFormReponseVO returnFaild() {
		CheckLoanFormReponseVO result = new CheckLoanFormReponseVO();
		result.setCode(SysDicEnum.ERROR.getCode());
		result.setMessage("数据请求失败");
		return result;
	}
}
