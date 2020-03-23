package com.pro.study.vo.response.workflow;

import com.pro.study.vo.response.sys.SysResponseVO;

/**
 * 
* @author: wgl
* @date: 2020年3月23日上午3:32:15 
* @version:1.0
* @Description:规则字段前端返回类
 */
public class RuleFieldReponseVO extends SysResponseVO{
	
	/**
	 * 规则字段id
	 */
	private Long id;
	
	/**
	 * 规则名
	 */
	private String fieldName;
	
	public RuleFieldReponseVO(Integer code, String message, Long id, String fieldName) {
		super(code, message);
		this.id = id;
		this.fieldName = fieldName;
	}

	public RuleFieldReponseVO(Integer code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public String toString() {
		return "RuleFieldReponseVO [id=" + id + ", fieldName=" + fieldName + "]";
	}
}
