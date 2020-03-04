package com.pro.study.vo.response.user;

import com.pro.study.enums.SysLoanApplyTableEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月3日下午6:18:18 
* @version:1.0
* @Description: 贷款申请表用户基本信息
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplyTableUserBaseInfoVO {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 性别
	 */
	private Integer sex;
	
	/**
	 * 性别中文
	 */
	private String sexName;
	
	
	/**
	 * 身份证号
	 */
	private String idCard;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 手机号
	 */
	private String phoneNumber;
	
	
	public void setSexByEnum(SysLoanApplyTableEnum  loanApplyEnum) {
		this.sex=loanApplyEnum.getCode();
		this.sexName=loanApplyEnum.getMessage();
	}
	
}
