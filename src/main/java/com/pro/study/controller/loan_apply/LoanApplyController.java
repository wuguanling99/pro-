package com.pro.study.controller.loan_apply;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.service.loan_aypply.LoanApplyService;
import com.pro.study.service.user.UserService;
import com.pro.study.vo.request.loan_apply.LoanApplyTableRequestVO;
import com.pro.study.vo.response.loan_apply.CreateLoanApplyTableResponseVO;
import com.pro.study.vo.response.user.LoanApplyTableUserBaseInfoVO;

/** 
* @author: wgl
* @date: 2020年3月3日下午4:58:42 
* @version:1.0
* @Description: 贷款申请视图层
*/
@RestController
@RequestMapping("/loanApply")
public class LoanApplyController {
	
	@Autowired
	private LoanApplyService loanApplyServoce;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	* @Description:（获取贷款申请表基本信息） 
	* 方法返回值: @param request
	* 方法返回值: @return
	* 方法返回值: @throws ParseException
	 */
	@GetMapping("/getLoanApplyUserInfo")
	public LoanApplyTableUserBaseInfoVO getLoanApplyUserInfo(HttpServletRequest request) throws ParseException {
		return userService.getBaseUserInfo(request);
	}
	
	@PostMapping("/createLoanApplyTable")
	public CreateLoanApplyTableResponseVO createLoanOrder(@Validated @RequestBody LoanApplyTableRequestVO loanApplyTable,
			HttpServletRequest request) {
		return loanApplyServoce.createLoanApplyTable(loanApplyTable,request);
	}
}
