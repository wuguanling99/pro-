package com.pro.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pro.study.dao.role.ProAuthRepository;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.enums.SysRoleEnum;
import com.pro.study.po.role.ProAuth;

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
	
	@Test
	public void saveData() {
		//                            角色id               权限名称				URL				 是否需要权限认证				是否需要解密
		ProAuth getKeyUrl = new ProAuth(null,SysRoleEnum.PASSROLE.getRole(),"/key/getRSAKey",SysDicEnum.DONTNEED.getCode(),SysDicEnum.DONTNEED.getCode());
		ProAuth createUserUrl = new ProAuth(null,SysRoleEnum.PASSROLE.getRole(),"/user/createLoanApplicant",SysDicEnum.DONTNEED.getCode(),SysDicEnum.NEED.getCode());
		ProAuth login = new ProAuth(null,SysRoleEnum.PASSROLE.getRole(),"/user/login",SysDicEnum.DONTNEED.getCode(),SysDicEnum.NEED.getCode());
		authRepository.save(login);
		authRepository.save(getKeyUrl);
		authRepository.save(createUserUrl);
	}

}
