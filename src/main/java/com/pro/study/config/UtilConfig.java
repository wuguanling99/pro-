package com.pro.study.config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.pro.study.enums.SysRoleEnum;
import com.pro.study.service.role.RoleService;
import com.pro.study.utils.PermitUrlsUtil;

@Component
public class UtilConfig implements InitializingBean{

	@Autowired
	private RoleService roleService;
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//对权限的内存进行赋值
		//查询获取所有的接口对应的权限
		Map<String, List<String>> roleUrlList = roleService.getAllRoleAndUrlAuth();
		List<String> needDecryurls = roleService.getNeedDecryPermitUrls();
		List<String> dontNeedDecryurls = roleService.getDontNeedDecryPermitUrls();
		PermitUrlsUtil.setPassUrls(roleUrlList.get(SysRoleEnum.PASSROLE.getRole()));
		PermitUrlsUtil.setRoleUrls(roleUrlList);
		PermitUrlsUtil.setDontNeedDecryptList(dontNeedDecryurls);
		PermitUrlsUtil.setNeedDecryptList(needDecryurls);
	}
}
