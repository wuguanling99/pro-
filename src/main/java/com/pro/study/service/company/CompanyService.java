package com.pro.study.service.company;

import javax.servlet.http.HttpServletRequest;

import com.pro.study.vo.response.company.CompanyResponseVO;
import com.pro.study.vo.response.company.LoanerLocationMapResponseVO;

/** 
* @author: wgl
* @date: 2020年2月26日下午11:03:17 
* @version:1.0
* @Description: 公司业务层
*/
public interface CompanyService {
	
	/**
	 * 
	* @Description:（获取公司信息） 
	* 方法返回值: @return
	 */
	CompanyResponseVO geCompanyList();
	
	/**
	 * 
	* @Description:（获取贷款人分布地图） 
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	LoanerLocationMapResponseVO getLocationMap(HttpServletRequest request);

}
