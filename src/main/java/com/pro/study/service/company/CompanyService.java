package com.pro.study.service.company;

import com.pro.study.vo.response.company.CompanyResponseVO;

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

}
