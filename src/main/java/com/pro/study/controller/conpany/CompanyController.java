package com.pro.study.controller.conpany;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.service.company.CompanyService;
import com.pro.study.utils.UserUtils;
import com.pro.study.vo.request.sys.PageInfo;
import com.pro.study.vo.request.workflow.WorkFlowRequestVO;
import com.pro.study.vo.response.company.CheckLoanFormReponseVO;
import com.pro.study.vo.response.company.CompanyResponseVO;
import com.pro.study.vo.response.company.LoanerLocationMapResponseVO;
import com.pro.study.vo.response.product.ProductResponseVO;
import com.pro.study.vo.response.workflow.WorkFLowResponseVO;


/** 
* @author: wgl
* @date: 2020年2月26日下午21:58:12 
* @version:1.0
* @Description: 用户视图层
*/
@RestController
@RequestMapping("/company")
public class CompanyController{
	
	@Autowired
	private CompanyService companyService;
	
	/**
	 * 
	* @Description:（获取公司产品信息） 
	* 方法返回值: @return
	 */
	@GetMapping("/getCompanyProductInfo")
	public CompanyResponseVO getCompanyProductInfo() {
		//根据用户获取公司
		return companyService.geCompanyList();
	} 
	
	
	/**
	 * 
	* @Description:（获取产品详情） 
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	@GetMapping("/getProductInfo")
	public List<ProductResponseVO> getProductInfo(HttpServletRequest request) {
		return companyService.getProductInfo(UserUtils.getUser(request));
	}
	
	/**
	 * 
	* @Description:（获取贷款人城市分布的接口） 
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	@GetMapping("/getLocationMap")
	public LoanerLocationMapResponseVO getLocationMap(HttpServletRequest request) {
		return companyService.getLocationMap(request);
	}
	
	/**
	 * 
	* @Description:（创建工作流） 
	* 方法返回值: @return
	 */
	public WorkFLowResponseVO createWorkFlow(HttpServletRequest request,@RequestBody WorkFlowRequestVO workflow) {
		UserInfoDTO user = UserUtils.getUser(request);
		return companyService.createWorkFlow(user,workflow);
	}
	
	
	//==================================审核员================================================
	/**
	 * 
	* @Description:（获取待审核列表的方法） 
	* 方法返回值: @return
	* 方法返回值: @param page
	 */
	@GetMapping("/getMyToBeAuditedList")
	public CheckLoanFormReponseVO getMyToBeAuditedList(HttpServletRequest request){
		UserInfoDTO user = UserUtils.getUser(request);
		return companyService.getMyToBeAuditedList(user);
	}
	
	/**
	 * 
	* @Description:（获取所有审核订单） 
	* 方法返回值: @param request
	* 方法返回值: @param page
	* 方法返回值: @return
	 */
	@GetMapping("/getAllAuditedList")
	public CheckLoanFormReponseVO getAllAuditedList(HttpServletRequest request,@RequestBody PageInfo page) {
		return companyService.getAllAuditedList(UserUtils.getUser(request),page);
	}
}