package com.pro.study;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pro.study.dao.role.MenuMybatisDao;
import com.pro.study.dao.role.RoleMybatisDao;
import com.pro.study.dao.user.UserMybatisDao;
import com.pro.study.dto.role.RoleDto;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.enums.SysRoleEnum;
import com.pro.study.po.role.Menu;
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
	private UserMybatisDao userDao;
	
	@Autowired
	private MenuMybatisDao menuDao;
	
	@Autowired
	private RoleMybatisDao roleDao;
	
	@Test
	public void saveUrl() {
		//封装url                      角色id               权限名称				URL				 是否需要权限认证				是否需要解密
		ProAuth getKeyUrl = new ProAuth(null,SysRoleEnum.PASSROLE.getRole(),"/key/getRSAKey",SysDicEnum.DONTNEED.getCode(),SysDicEnum.DONTNEED.getCode());
//		userDao.insertUser(getKeyUrl);
		ProAuth createUserUrl = new ProAuth(null,SysRoleEnum.PASSROLE.getRole(),"/user/createLoanApplicant",SysDicEnum.DONTNEED.getCode(),SysDicEnum.NEED.getCode());
//		userDao.insertUser(createUserUrl);
		ProAuth login = new ProAuth(null,SysRoleEnum.PASSROLE.getRole(),"/user/login",SysDicEnum.DONTNEED.getCode(),SysDicEnum.NEED.getCode());
//		userDao.insertUser(login);
//		ProAuth getUserBaseInfo = new ProAuth(2L,SysRoleEnum.LOAN_APPLY.getRole(),"/user/getUserBaseInfo",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
//		userDao.insertUser(getUserBaseInfo);
//		ProAuth updateUserInfo = new ProAuth(2L,SysRoleEnum.LOAN_APPLY.getRole(),"/user/updatePerBaseInfo",SysDicEnum.NEED.getCode(),SysDicEnum.NEED.getCode());
//		userDao.insertUser(updateUserInfo);
//		ProAuth uploadImage = new ProAuth(2L,SysRoleEnum.LOAN_APPLY.getRole(),"/user/uploadUserHeadImage",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
//		userDao.insertUser(uploadImage);
//		ProAuth searchLoanApplyList = new ProAuth(2L,SysRoleEnum.LOAN_APPLY.getRole(),"/loanApply/searchLoanTable",SysDicEnum.NEED.getCode(),SysDicEnum.NEED.getCode());
//		userDao.insertUser(searchLoanApplyList);
//		ProAuth createLoanTable = new ProAuth(2L,SysRoleEnum.LOAN_APPLY.getRole(),"/loanApply/createLoanApplyTable",SysDicEnum.NEED.getCode(),SysDicEnum.NEED.getCode());
//		userDao.insertUser(createLoanTable);
//		ProAuth uploadPerIdCardImage = new ProAuth(2L,SysRoleEnum.LOAN_APPLY.getRole(),"/loanApply/uploadPerIdCardImage",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
//		userDao.insertUser(uploadPerIdCardImage);
//		ProAuth uploadBankCardImage = new ProAuth(2L,SysRoleEnum.LOAN_APPLY.getRole(),"/loanApply/uploadBankCardImage",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
//		userDao.insertUser(uploadBankCardImage);
//		ProAuth uploadBankCardImage = new ProAuth(2L,SysRoleEnum.LOAN_APPLY.getRole(),"/loanApply/uploadBankCardImage",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
//		userDao.insertUser(uploadBankCardImage);
		//===============公司管理员接口==========================
		ProAuth createNode = new ProAuth(4L,SysRoleEnum.COMPANY_MANAGER.getRole(),"/company/createNode",SysDicEnum.NEED.getCode(),SysDicEnum.NEED.getCode());
		userDao.insertUser(createNode);
//		ArrayList<ProAuth> menuList = new ArrayList<ProAuth>();
//		menuList.add(new ProAuth(null,SysRoleEnum.IT_ADMIN.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode()));
//		menuList.add(new ProAuth(null,SysRoleEnum.CHECK.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode()));
//		menuList.add(new ProAuth(null,SysRoleEnum.LOAN_APPLY.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode()));
//		menuList.add(new ProAuth(null,SysRoleEnum.COMPANY_MANAGER.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode()));
//		for (ProAuth proAuth : menuList) {
//			userDao.insertUser(proAuth);
//		}
//		ProAuth logout = new ProAuth(null,SysRoleEnum.LOAN_APPLY.getRole(),"/user/logout",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
//		ProAuth menuLoanApply = new ProAuth(null,SysRoleEnum.LOAN_APPLY.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
//		ProAuth menuCompanyManager = new ProAuth(null,SysRoleEnum.COMPANY_MANAGER.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
//		ProAuth menuCheck = new ProAuth(null,SysRoleEnum.CHECK.getRole(),"/role/getMenu",SysDicEnum.NEED.getCode(),SysDicEnum.DONTNEED.getCode());
		//封装目录
//		List<RoleDto> findByDeleteFlag = roleDao.findAllRoleByDeleteFlag(SysDicEnum.SYS_VALID.getCode());
//		for (RoleDto proRole : findByDeleteFlag) {
//			Menu homeMenu = new Menu(0l, "首页","url", proRole.getId());
//			//封装首页
//			menuDao.insertMenu(homeMenu);
//		}
		//查询贷款申请人角色id
//		RoleDto role = roleDao.findByRoleNameAndDeleteFlag(SysRoleEnum.LOAN_APPLY.getRole(),SysDicEnum.SYS_VALID.getCode());
//		Menu daikuanMenu = new Menu(0l, "贷款","url", role.getId());
//		Long menuId = menuDao.insertMenu(daikuanMenu);
		//添加子目录
//		Menu myLoanMenu = new Menu(5l, "我的贷款","url", role.getId());
//		Menu iwantApply = new Menu(5l, "我要申请","url", role.getId());
//		menuDao.insertMenu(myLoanMenu);
//		menuDao.insertMenu(iwantApply);
	}
	
	
	
}
