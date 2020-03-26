package com.pro.study.vo.response.workflow;

import java.util.List;

import com.pro.study.vo.request.workflow.BodyRequestVO;
import com.pro.study.vo.response.sys.SysResponseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月27日上午1:41:39 
* @version:1.0
* @Description:规则返回类
 */
@Data
public class RuleInfoResponseVO extends SysResponseVO{

	/**
	 * 规则id
	 */
	private Long id;
	
	/**
	 * 规则名
	 */
	private String ruleName;
	
	/**
	 * 规则描述
	 */
	private String ruleDescribe;
	
	/**
	 * 规则体
	 */
	private List<BodyRequestVO> ruleBody;

	public RuleInfoResponseVO(Integer code, String message, Long id, String ruleName, String ruleDescribe,
			List<BodyRequestVO> ruleBody) {
		super(code, message);
		this.id = id;
		this.ruleName = ruleName;
		this.ruleDescribe = ruleDescribe;
		this.ruleBody = ruleBody;
	}

	public RuleInfoResponseVO(Integer code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RuleInfoResponseVO [id=" + id + ", ruleName=" + ruleName + ", ruleDescribe=" + ruleDescribe
				+ ", ruleBody=" + ruleBody + "]";
	}

}
