package com.pro.study.dao.role;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.role.ProRole;
import com.pro.study.po.user.User;
/**
 * 
* @author: wgl
* @date: 2020年2月29日上午1:55:52 
* @version:1.0
* @Description: roleDao数据接口层
 */
public interface ProRoleRepository extends JpaSpecificationExecutor<ProRole>, CrudRepository<ProRole, Long> {


}
