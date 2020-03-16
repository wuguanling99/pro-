package com.pro.study.controller.loan_apply;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pro.study.service.loan_aypply.LoanApplyService;
import com.pro.study.service.user.UserService;
import com.pro.study.utils.UserUtils;
import com.pro.study.vo.request.loan_apply.LoanApplyTableRequestVO;
import com.pro.study.vo.request.sys.PageInfo;
import com.pro.study.vo.response.loan_apply.CreateLoanApplyTableResponseVO;
import com.pro.study.vo.response.loan_apply.ImageResponseVO;
import com.pro.study.vo.response.loan_apply.LoanApplyFromResponseVo;
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
	private LoanApplyService loanApplyService;
	
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
		
	/**
	 * 
	* @Description:（创建贷款申请表） 
	* 方法返回值: @param loanApplyTable
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	@PostMapping("/createLoanApplyTable")
	public CreateLoanApplyTableResponseVO createLoanOrder(@Validated @RequestBody LoanApplyTableRequestVO loanApplyTable,
			HttpServletRequest request) {
		return loanApplyService.createLoanApplyTable(loanApplyTable,request);
	}
	
	/**
	 * 
	* @Description:（图片上传） 
	* 方法返回值: @param file
	* 方法返回值: @return
	 */
	@PostMapping("/uploadImage")
	public ImageResponseVO  uploadImage(@RequestParam("file") MultipartFile file) {
		return loanApplyService.uploadImage(file);
	}
	
	/**
	 * 
	* @Description:（根据用户获取用户已申请贷款列表） 待审核
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	@GetMapping("/getMyLoanApplyTableList")
	public List<LoanApplyFromResponseVo> getMyLoanApplyTableList(HttpServletRequest request,@RequestBody PageInfo page) {
		return loanApplyService.getLoanApplyTableListByUser(UserUtils.getUser(request),page);
	}
}
