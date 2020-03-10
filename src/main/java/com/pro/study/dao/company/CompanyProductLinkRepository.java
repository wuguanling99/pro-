package com.pro.study.dao.company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.company.CompanyProductLink;

/** 
* @author: wgl
* @date: 2020年3月5日上午2:32:08 
* @version:1.0
* @Description: 公司产品关联表数据层
*/
public interface CompanyProductLinkRepository extends JpaSpecificationExecutor<CompanyProductLink>, CrudRepository<CompanyProductLink, Long> {
	
	/**
	 * 
	* @Description:（根据公司id查询对应的产品列表） 
	* 方法返回值: @param companyId
	* 方法返回值: @return
	 */
	List<CompanyProductLink> findByCompanyId(Long companyId);
	
	/**
	 * 
	* @Description:（根据产品id查询公司关联信息） 
	* 方法返回值: @param productId
	* 方法返回值: @return
	 */
	CompanyProductLink findByProductId(Long productId);

}
