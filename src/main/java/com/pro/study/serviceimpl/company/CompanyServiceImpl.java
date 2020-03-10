package com.pro.study.serviceimpl.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pro.study.dao.company.CompanyMybaitsDao;
import com.pro.study.dao.company.CompanyProductLinkRepository;
import com.pro.study.dao.company.CompanyRepository;
import com.pro.study.dao.product.ProductRepository;
import com.pro.study.dto.company.CompanyDto;
import com.pro.study.dto.company.CompanyLoanerLocationDto;
import com.pro.study.dto.company.LocationMapDto;
import com.pro.study.dto.company.ProductDto;
import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.po.company.Company;
import com.pro.study.po.company.CompanyProductLink;
import com.pro.study.po.product.Product;
import com.pro.study.service.company.CompanyService;
import com.pro.study.utils.UserUtils;
import com.pro.study.vo.response.company.CompanyResponseVO;
import com.pro.study.vo.response.company.LoanerLocationMapResponseVO;
import com.pro.study.vo.response.product.ProductResponseVO;

/** 
* @author: wgl
* @date: 2020年2月26日下午11:03:43 
* @version:1.0
* @Description: 公司业务层实现类
*/
@Service
public class CompanyServiceImpl implements CompanyService{
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyProductLinkRepository companyProductRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CompanyMybaitsDao companyDao;
	
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
	
	/**
	 * 获取贷款人分布地图
	 */
	@Override
	public LoanerLocationMapResponseVO getLocationMap(HttpServletRequest request) {
		LoanerLocationMapResponseVO result = new LoanerLocationMapResponseVO();
		UserInfoDTO user = UserUtils.getUser(request);
		List<CompanyLoanerLocationDto> loanerLocation = companyDao.getLonerLocationMapByCompanyId(user.getCompanyId());
		result.setCode(HttpStatus.OK.value());
		List<LocationMapDto> data = new ArrayList<LocationMapDto>();
		for (CompanyLoanerLocationDto companyLoanerLocationDto : loanerLocation) {
			LocationMapDto locationMapDto = new LocationMapDto();
			BeanUtils.copyProperties(companyLoanerLocationDto, locationMapDto);
			data.add(locationMapDto);
		}
		result.setLocationData(data);
		return result;
	}
	
	/**
	 * 获取产品信息
	 */
	@Override
	public List<ProductResponseVO> getProductInfo(UserInfoDTO user) {
		List<ProductResponseVO> result = new ArrayList<ProductResponseVO>();
		//公司id
		Long companyId = user.getCompanyId();
		Company company = companyRepository.findById(companyId).get();
		//根据公司Id查询所有的产品信息
		List<CompanyProductLink> comopanyProductLinkList = companyProductRepository.findByCompanyId(companyId);
		//拿到所有的公司订单信息
		for (CompanyProductLink index : comopanyProductLinkList) {
			Product product = productRepository.findById(index.getProductId()).get();
			ProductResponseVO data = new ProductResponseVO();
			data.setProductId(index.getProductId());
			data.setProductName(product.getProductName());
			data.setCreateDate(sdf.format(product.getCreateTime()));
			//TODO 查询每个产品对应的申请人总数和放款总金额
			//添加数据到result
			result.add(data);
		}
		return result;
	}

}
