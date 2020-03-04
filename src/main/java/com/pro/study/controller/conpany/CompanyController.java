package com.pro.study.controller.conpany;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.service.company.CompanyService;
import com.pro.study.vo.response.company.CompanyResponseVO;


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
	
	@GetMapping("/getCompany")
	public CompanyResponseVO getCompanyByUser() {
		//根据用户获取公司
		return companyService.geCompanyList();
	} 
	
	
	
}