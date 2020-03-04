package com.pro.study.serviceimpl.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pro.study.dao.company.CompanyProductLinkRepository;
import com.pro.study.dao.company.CompanyRepository;
import com.pro.study.dao.product.ProductRepository;
import com.pro.study.dto.company.CompanyDto;
import com.pro.study.dto.company.ProductDto;
import com.pro.study.po.company.Company;
import com.pro.study.po.company.CompanyProductLink;
import com.pro.study.po.product.Product;
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
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyProductLinkRepository companyProductRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * 获取公司信息
	 */
	@Override
	public CompanyResponseVO geCompanyList() {
		CompanyResponseVO result = new CompanyResponseVO();
		//首先获取所有的公司
		Iterable<Company> allCompany = companyRepository.findAll();
		Iterator<Company> it = allCompany.iterator();
		if(!it.hasNext()) {
			return new CompanyResponseVO(HttpStatus.OK.value(),null);
		}else {
			List<CompanyDto> companyList = new ArrayList<CompanyDto>();
			while (it.hasNext()) {
				Company company = it.next();
				Long companyId = company.getId();
				//根据公司id查询关联表获取产品id
				List<CompanyProductLink> linkData = companyProductRepository.findByCompanyId(companyId);
				List<ProductDto> productList = new ArrayList<ProductDto>();
				for (CompanyProductLink companyProductLink : linkData) {
					Product product = productRepository.findById(companyProductLink.getProductId()).get();
					productList.add(new ProductDto(product.getId(),product.getProductName()));
				}
			}
			result.setCompanyNameList(companyList);
			result.setCode(HttpStatus.OK.value());
		}
		//获取公司对应的产品列表
		//封装数据
		return result;
	}

}
