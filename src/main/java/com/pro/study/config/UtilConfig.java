package com.pro.study.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pro.study.service.role.RoleService;

@Component
public class UtilConfig implements InitializingBean{

	@Autowired
	private RoleService roleService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//对权限的内存进行赋值
		roleService.getAllRoleAndUrlAuth();
	}

}
