package com.pro.study.dao.company;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.company.Company;
/**
 * 
* @author: wgl
* @date: 2020年2月29日上午1:52:52 
* @version:1.0
* @Description: company数据接口层
 */
public interface CompanyRepository extends JpaSpecificationExecutor<Company>, CrudRepository<Company, Long> {


}
