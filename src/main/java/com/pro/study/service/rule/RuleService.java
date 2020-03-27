package com.pro.study.service.rule;

import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.vo.request.sys.PageInfo;
import com.pro.study.vo.request.workflow.RuleAndBodyRequestVO;
import com.pro.study.vo.request.workflow.RulePage;
import com.pro.study.vo.response.company.RuleFieldAndDicReponseVO;
import com.pro.study.vo.response.sys.Page;
import com.pro.study.vo.response.sys.SysListResponseVO;
import com.pro.study.vo.response.sys.SysResponseVO;
import com.pro.study.vo.response.workflow.RuleInfoResponseVO;

public interface RuleService {
	
	/**
	 * 
	* @param productId 
	 * @Description:（获取产品下的规则字段） 
	* 方法返回值: @param user
	* 方法返回值: @param productId
	* 方法返回值: @return
	 */
	SysListResponseVO<RuleFieldAndDicReponseVO> getAllRuleField(UserInfoDTO user, Long productId);
	
	/**
	 * 
	* @Description:（添加规则） 
	* 方法返回值: @param user
	* 方法返回值: @param ruleVO
	* 方法返回值: @return
	 */
	SysResponseVO createRule(UserInfoDTO user, RuleAndBodyRequestVO ruleVO);
	
	/**
	 * 
	* @Description:（分页获取规则） 
	* 方法返回值: @param user
	* 方法返回值: @param page
	* 方法返回值: @return
	 */
	Page getRuleByPage(UserInfoDTO user, PageInfo page);
	
	/**
	 * 获取规则信息
	* @Description:（方法功能描述） 
	* 方法返回值: @param user
	* 方法返回值: @return
	 */
	RuleInfoResponseVO getRuleInfo(UserInfoDTO user, Long id);
	
	/**
	 * 
	* @Description:（修改规则） 
	* 方法返回值: @param user
	* 方法返回值: @param rule
	* 方法返回值: @return
	 */
	SysResponseVO updateRule(UserInfoDTO user, RuleAndBodyRequestVO rule);
	
	/**
	 * 
	* @Description:（删除规则） 
	* 方法返回值: @param user
	* 方法返回值: @param id
	* 方法返回值: @return
	 */
	SysResponseVO deleteRule(UserInfoDTO user, Long id);
	
	/**
	 * 
	* @Description:（获取所有关联关系的规则） 
	* 方法返回值: @param user
	* 方法返回值: @param id
	* 方法返回值: @return
	 */
	Page getRuleByLinkPage(UserInfoDTO user, RulePage page);

}
