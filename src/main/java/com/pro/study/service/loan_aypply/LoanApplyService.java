package com.pro.study.service.loan_aypply;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.pro.study.vo.request.loan_apply.LoanApplyTableRequestVO;
import com.pro.study.vo.response.loan_apply.CreateLoanApplyTableResponseVO;
import com.pro.study.vo.response.loan_apply.ImageResponseVO;

/** 
* @author: wgl
* @date: 2020年3月3日下午5:59:06 
* @version:1.0
* @Description: 贷款申请service
*/
public interface LoanApplyService {
	
	/**
	 * 
	* @Description:（创建贷款申请表） 
	* 方法返回值: @param loanApplyTable
	* 方法返回值: @return
	 */
	CreateLoanApplyTableResponseVO createLoanApplyTable(LoanApplyTableRequestVO loanApplyTable,HttpServletRequest request);
	
	/**
	 * 
	* @param file 
	 * @Description:（图片上传） 
	* 方法返回值: @return
	 */
	ImageResponseVO uploadImage(MultipartFile file);

}
