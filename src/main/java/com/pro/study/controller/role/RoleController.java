package com.pro.study.controller.role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.service.role.RoleService;
import com.pro.study.vo.response.role.MenuResponseVO;

/** 
* @author: wgl
* @date: 2020年2月28日下午11:54:28 
* @version:1.0
* @Description: 角色视图层
*/
@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/getMenu")
	public List<MenuResponseVO> getMenu(HttpServletRequest request) {
		//获取对应用户的目录
		return roleService.getMenuByRoleId(request);
	}
	
}