package com.pro.study.dao.user;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.user.User;
/**
 * 
* @author: wgl
* @date: 2020年2月29日上午1:59:52 
* @version:1.0
* @Description: userDao数据接口层
 */
public interface UserRepository extends JpaSpecificationExecutor<User>, CrudRepository<User, Long> {

	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String scrypt);

}
