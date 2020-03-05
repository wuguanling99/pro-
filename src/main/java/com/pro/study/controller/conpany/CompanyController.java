package com.pro.study.controller.conpany;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.service.company.CompanyService;
import com.pro.study.vo.response.company.CompanyResponseVO;
import com.pro.study.vo.response.company.LoanerLocationMapResponseVO;


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
	* @Description:（获取贷款人城市分布的接口） 
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	@GetMapping("/getLocationMap")
	public LoanerLocationMapResponseVO getLocationMap(HttpServletRequest request) {
		return companyService.getLocationMap(request);
	}
}