package com.pro.study.dao.company;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.role.ProRole;
import com.pro.study.po.user.User;
/**
 * 
* @author: wgl
* @date: 2020年2月29日上午1:52:52 
* @version:1.0
* @Description: company数据接口层
 */
public interface CompanyRepository extends JpaSpecificationExecutor<ProRole>, CrudRepository<ProRole, Long> {


}
