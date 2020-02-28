package com.pro.study.serviceimpl.role;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.study.dao.role.ProRoleRepository;
import com.pro.study.po.role.ProRole;
import com.pro.study.service.role.RoleService;

/**
 * 
* @author: wgl
* @date: 2020年2月29日上午1:34:59 
* @version:1.0
* @Description:角色业务实现类
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private ProRoleRepository roleMapper;
	
	@Override
	public Set<Map<String, List<String>>> getAllRoleAndUrlAuth() {
		Optional<ProRole> findById = roleMapper.findById(1l);
		ProRole proRole = findById.get();
		System.out.println(proRole);
		return null;
	}

}