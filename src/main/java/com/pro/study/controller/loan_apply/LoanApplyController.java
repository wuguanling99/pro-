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
import com.pro.study.vo.request.sys.SearchPageInfoRequestVO;
import com.pro.study.vo.response.loan_apply.CreateLoanApplyTableResponseVO;
import com.pro.study.vo.response.loan_apply.LoanApplyFromResponseVo;
import com.pro.study.vo.response.sys.ImageReponseVO;
import com.pro.study.vo.response.sys.SysListResponseVO;
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
	* @Description:（根据用户获取用户已申请贷款列表） 待审核
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	@GetMapping("/getMyLoanApplyTableList")
	public List<LoanApplyFromResponseVo> getMyLoanApplyTableList(HttpServletRequest request,@RequestBody PageInfo page) {
		return loanApplyService.getLoanApplyTableListByUser(UserUtils.getUser(request),page);
	}
	
	/**
	 * 
	* @Description:（根据用户获取用户已申请贷款列表）
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	@GetMapping("/searchLoanTable")
	public SysListResponseVO searchLoanTable(HttpServletRequest request,@RequestBody SearchPageInfoRequestVO searchPageInfo) {
		return loanApplyService.searchLoanTable(UserUtils.getUser(request),searchPageInfo);
	}
	
	/**
	 * 
	* @Description:（身份证照片上传） 
	* 方法返回值: @param request
	* 方法返回值: @param file
	* 方法返回值: @param face 正反面标志
	* 方法返回值: @return
	 */
	@PostMapping("/uploadPerIdCardImage")
	public ImageReponseVO uploadPerIdCardImage(HttpServletRequest request,@RequestParam(value = "file") MultipartFile file,@RequestParam(value="face")Integer face) {
		return loanApplyService.uploadPerIdCardImage(UserUtils.getUser(request),face,file);
	}
	
	/**
	 * 
	* @Description:（银行卡正反面上传） 
	* 方法返回值: @param request
	* 方法返回值: @param file
	* 方法返回值: @param face 正反面标志
	* 方法返回值: @return
	 */
	@PostMapping("/uploadBankCardImage")
	public ImageReponseVO uploadBankCardImage(HttpServletRequest request,@RequestParam(value = "file") MultipartFile file,@RequestParam(value="face")Integer face) {
		return loanApplyService.uploadBankCardImage(UserUtils.getUser(request),face,file);
	}
	/**
	 * 
	* @Description:（信用卡正反面上传） 
	* 方法返回值: @param request
	* 方法返回值: @param file
	* 方法返回值: @param face 正反面标志
	* 方法返回值: @return
	 */
	@PostMapping("/uploadCreditCardImage")
	public ImageReponseVO uploadCreditCardImage(HttpServletRequest request,@RequestParam(value = "file") MultipartFile file,@RequestParam(value="face")Integer face) {
		return loanApplyService.uploadCreditCardImage(UserUtils.getUser(request),face,file);
	}
}
