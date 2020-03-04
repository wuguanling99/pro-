package com.pro.study.serviceimpl.company;

import org.springframework.stereotype.Service;

import com.pro.study.service.company.CompanyService;
import com.pro.study.vo.response.company.CompanyResponseVO;

/** 
* @author: wgl
* @date: 2020年2月26日下午11:03:43 
* @version:1.0
* @Description: 公司业务层实现类
*/
@Service
public class CompanyServiceImpl implements CompanyService{
	
	
	
	/**
	 * 获取公司信息
	 */
	@Override
	public CompanyResponseVO geCompanyList() {
		//首先获取所有的公司
		//获取公司对应的产品列表
		//封装数据
		return null;
	}

}
