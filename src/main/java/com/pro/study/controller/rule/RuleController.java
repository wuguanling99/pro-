package com.pro.study.controller.rule;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.service.rule.RuleService;
import com.pro.study.utils.UserUtils;
import com.pro.study.vo.request.sys.PageInfo;
import com.pro.study.vo.request.workflow.RuleAndBodyRequestVO;
import com.pro.study.vo.request.workflow.RulePage;
import com.pro.study.vo.response.company.RuleFieldAndDicReponseVO;
import com.pro.study.vo.response.sys.Page;
import com.pro.study.vo.response.sys.SysListResponseVO;
import com.pro.study.vo.response.sys.SysResponseVO;
import com.pro.study.vo.response.workflow.RuleInfoResponseVO;

/** 
* @author: wgl
* @date: 2020年2月23日下午1:38:55 
* @version:1.0
* @Description: 规则视图层
*/
@RestController
@RequestMapping("/rule")
public class RuleController{
	
	@Autowired
	private RuleService ruleService;
	
	/**
	 * 
	* @Description:（获取所有的规则字段）  
	* 方法返回值: @return
	 */
	@GetMapping("/getAllRuleField")
	public SysListResponseVO<RuleFieldAndDicReponseVO> getAllRuleField(HttpServletRequest request,@RequestParam("productId")Long productId) {
		UserInfoDTO user = UserUtils.getUser(request);
		return ruleService.getAllRuleField(user,productId);
	}
	
	/**
	 * 
	* @Description:（获取所有的规则字段）  
	* 方法返回值: @return
	 */
	@PostMapping("/createRule")
	public SysResponseVO createRule(HttpServletRequest request,@RequestBody RuleAndBodyRequestVO ruleVO) {
		UserInfoDTO user = UserUtils.getUser(request);
		return ruleService.createRule(user,ruleVO);
	}
	
	/**
	 * 
	* @Description:（获取所有的规则字段）  
	* 方法返回值: @return
	 */
	@GetMapping("/getRuleByPage")
	public Page getRuleByPage(HttpServletRequest request,@RequestBody PageInfo page) {
		UserInfoDTO user = UserUtils.getUser(request);
		return ruleService.getRuleByPage(user,page);
	}
	
	/**
	 * 
	* @Description:（获取规则信息）  
	* 方法返回值: @return
	 */
	@GetMapping("/getRuleInfo")
	public RuleInfoResponseVO getRuleInfo(HttpServletRequest request,@RequestParam("ruleId")Long id) {
		UserInfoDTO user = UserUtils.getUser(request);
		return ruleService.getRuleInfo(user,id);
	}
	
	/**
	 * 
	* @Description:（修改规则）  
	* 方法返回值: @return
	 */
	@PostMapping("/updateRule")
	public SysResponseVO updateRule(HttpServletRequest request,@RequestBody RuleAndBodyRequestVO rule) {  
		UserInfoDTO user = UserUtils.getUser(request);
		return ruleService.updateRule(user,rule);
	}
	
	/**
	 * 
	* @Description:（删除规则）  
	* 方法返回值: @return
	 */
	@GetMapping("/deleteRule")
	public SysResponseVO deleteRule(HttpServletRequest request,@RequestParam("ruleId")Long id) {  
		UserInfoDTO user = UserUtils.getUser(request);
		return ruleService.deleteRule(user,id);
	}
	
	
	
	/**
	 * 
	* @Description:（查询所有未建立管理关系的规则）  
	* 方法返回值: @return
	 */
	@GetMapping("/getRuleByLinkPage")
	public Page getRuleByLinkPage(HttpServletRequest request,@RequestBody RulePage page) {  
		UserInfoDTO user = UserUtils.getUser(request);
		return ruleService.getRuleByLinkPage(user,page);
	}
}
