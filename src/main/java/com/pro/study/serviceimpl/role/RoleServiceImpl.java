package com.pro.study.serviceimpl.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.study.dao.role.ProAuthRepository;
import com.pro.study.dao.role.ProRoleRepository;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.enums.SysRoleEnum;
import com.pro.study.po.role.ProAuth;
import com.pro.study.po.role.ProRole;
import com.pro.study.po.user.User;
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
	
	@Autowired
	private ProAuthRepository authMapper;
	
	@Override
	public Map<String, List<String>> getAllRoleAndUrlAuth() {
		//创建一个保存最终结果的Set集合
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		//查询有没有数据
		Set<String> roleNameSet = new HashSet<String>();
		List<ProRole> allRoleList = roleMapper.findByDeleteFlag(SysDicEnum.SYS_VALID.getCode());
		if(!(allRoleList.size()>0)) {
			//封装默认值到数据库
			ProRole adminRole = new ProRole();
			adminRole.setRoleName(SysRoleEnum.IT_ADMIN.getRole());
			adminRole.setRoleDescribe(SysRoleEnum.IT_ADMIN.getRoleMsg());
			ProRole loanApply = new ProRole();
			loanApply.setRoleName(SysRoleEnum.LOAN_APPLY.getRole());
			loanApply.setRoleDescribe(SysRoleEnum.LOAN_APPLY.getRoleMsg());
			ProRole check = new ProRole();
			check.setRoleName(SysRoleEnum.CHECK.getRole());
			check.setRoleDescribe(SysRoleEnum.CHECK.getRoleMsg());
			ProRole companyControl = new ProRole();
			companyControl.setRoleName(SysRoleEnum.COMPANY_MANAGER.getRole()); 
			companyControl.setRoleDescribe(SysRoleEnum.COMPANY_MANAGER.getRoleMsg());
			roleMapper.save(adminRole);
			roleMapper.save(loanApply);
			roleMapper.save(check);
			roleMapper.save(companyControl);
			roleNameSet.add(adminRole.getRoleName());
			roleNameSet.add(loanApply.getRoleName());
			roleNameSet.add(check.getRoleName());
			roleNameSet.add(companyControl.getRoleName());
		}
		//查询所有的接口
		List<ProAuth> allUrl = authMapper.findByDeleteFlag(SysDicEnum.SYS_VALID.getCode());
		Map<String, List<ProAuth>> groupByRoleNameAuth = allUrl.stream().collect(Collectors.groupingBy(ProAuth::getRoleName));
		//按照角色名分配url
		List<String>  passUrlList = new ArrayList<String>();
		Set<String> keySet = groupByRoleNameAuth.keySet();
		for (String roleName : keySet) {
			List<ProAuth> authList = groupByRoleNameAuth.get(roleName);
			if(SysRoleEnum.PASSROLE.getRole().equals(roleName)) {
				//可以直接通过的接口
				passUrlList = authList.stream().map(ProAuth::getUrl).collect(Collectors.toList());
			}else {
			List<String> urlList = new ArrayList<String>();
			result.put(roleName, authList.stream().map(ProAuth::getUrl).collect(Collectors.toList()));
			}
		}
		result.put(SysRoleEnum.PASSROLE.getRole(), passUrlList);
		return result;
	}
	
	/**
	 * 查询所有的需要解密的url
	 */
	@Override
	public List<String> getNeedDecryPermitUrls() {
		List<ProAuth> authList = authMapper.findByDecryptFlag(SysDicEnum.NEED.getCode());
		return authList.stream().map(ProAuth::getUrl).collect(Collectors.toList());
	}
	
	/**
	 * 查询所有的不需要解密的url
	 */
	@Override
	public List<String> getDontNeedDecryPermitUrls() {
		List<ProAuth> authList = authMapper.findByDecryptFlag(SysDicEnum.DONTNEED.getCode());
		return authList.stream().map(ProAuth::getUrl).collect(Collectors.toList());
	}

}