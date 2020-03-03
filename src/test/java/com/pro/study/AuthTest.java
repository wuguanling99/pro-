package com.pro.study;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pro.study.dao.role.MenuRepository;
import com.pro.study.dao.role.ProAuthRepository;
import com.pro.study.dao.role.ProRoleRepository;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.enums.SysRoleEnum;
import com.pro.study.po.role.Menu;
import com.pro.study.po.role.ProAuth;
import com.pro.study.po.role.ProRole;

/** 
* @author: wgl
* @date: 2020年3月1日下午8:55:16 
* @version:1.0
* @Description: 权限单元测试
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProApi.class)
public class AuthTest {

	@Autowired
	private ProAuthRepository authRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private ProRoleRepository roleRepository;
	
	@Test
	public void saveData() {
		//封装url                      角色id               权限名称				URL				 是否需要权限认证				是否需要解密
		ProAuth getKeyUrl = new ProAuth(null,SysRoleEnum.PASSROLE.getRole(),"/key/getRSAKey",SysDicEnum.DONTNEED.getCode(),SysDicEnum.DONTNEED.getCode());
		ProAuth createUserUrl = new ProAuth(null,SysRoleEnum.PASSROLE.getRole(),"/user/createLoanApplicant",SysDicEnum.DONTNEED.getCode(),SysDicEnum.NEED.getCode());
		ProAuth login = new ProAuth(null,SysRoleEnum.PASSROLE.getRole(),"/user/login",SysDicEnum.DONTNEED.getCode(),SysDicEnum.NEED.getCode());
		ProAuth logout = new ProAuth(null,SysRoleEnum.LOAN_APPLY.getRole(),"/user/logout",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
		ProAuth menuLoanApply = new ProAuth(null,SysRoleEnum.LOAN_APPLY.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
		ProAuth menuAdmin = new ProAuth(null,SysRoleEnum.IT_ADMIN.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
		ProAuth menuCompanyManager = new ProAuth(null,SysRoleEnum.COMPANY_MANAGER.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
		ProAuth menuCheck = new ProAuth(null,SysRoleEnum.CHECK.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
		authRepository.save(menuCheck);
		authRepository.save(menuAdmin);
		authRepository.save(menuLoanApply);
		authRepository.save(menuCompanyManager);
		authRepository.save(logout);
		authRepository.save(login);
		authRepository.save(getKeyUrl);
		authRepository.save(createUserUrl);
		//封装目录
		List<ProRole> findByDeleteFlag = roleRepository.findByDeleteFlag(SysDicEnum.SYS_VALID.getCode());
		for (ProRole proRole : findByDeleteFlag) {
			Menu homeMenu = new Menu(0l, "首页","url", proRole.getId());
			//封装首页
			menuRepository.save(homeMenu);
		}
	}

}
