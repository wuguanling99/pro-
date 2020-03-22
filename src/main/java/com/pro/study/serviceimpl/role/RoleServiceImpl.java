package com.pro.study.serviceimpl.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.study.dao.role.MenuRepository;
import com.pro.study.dao.role.ProAuthMybatisDao;
import com.pro.study.dao.role.ProRoleRepository;
import com.pro.study.dao.role.RoleMybatisDao;
import com.pro.study.dto.role.AuthDTO;
import com.pro.study.dto.role.RoleDto;
import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.enums.SysRoleEnum;
import com.pro.study.po.role.Menu;
import com.pro.study.po.role.ProRole;
import com.pro.study.service.role.RoleService;
import com.pro.study.utils.UserUtils;
import com.pro.study.vo.response.role.MenuResponseVO;

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
	private RoleMybatisDao roleDao;
	
	@Autowired
	private ProAuthMybatisDao authDao;
	
	@Autowired
	private MenuRepository menuResitory;
	
	/**
	 * 获取所有角色和对应的url
	 */
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
		List<AuthDTO> allUrl = authDao.findByAllUrl(SysDicEnum.SYS_VALID.getCode());
		Map<String, List<AuthDTO>> groupByRoleNameAuth = allUrl.stream().collect(Collectors.groupingBy(AuthDTO::getRole_name));
		//按照角色名分配url
		List<String>  passUrlList = new ArrayList<String>();
		Set<String> keySet = groupByRoleNameAuth.keySet();
		for (String roleName : keySet) {
			List<AuthDTO> authList = groupByRoleNameAuth.get(roleName);
			if(SysRoleEnum.PASSROLE.getRole().equals(roleName)) {
				//可以直接通过的接口
				passUrlList = authList.stream().map(AuthDTO::getAuth_url).collect(Collectors.toList());
			}else {
			List<String> urlList = new ArrayList<String>();
			result.put(roleName, authList.stream().map(AuthDTO::getAuth_url).collect(Collectors.toList()));
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
		List<AuthDTO> authList = authDao.findByDecryptFlagAndDeleteFlag(SysDicEnum.NEED.getCode(),SysDicEnum.SYS_VALID.getCode());
		return authList.stream().map(AuthDTO::getAuth_url).collect(Collectors.toList());
	}
	
	/**
	 * 查询所有的不需要解密的url
	 */
	@Override
	public List<String> getDontNeedDecryPermitUrls() {
		List<AuthDTO> authList = authDao.findByDecryptFlagAndDeleteFlag(SysDicEnum.DONTNEED.getCode(),SysDicEnum.SYS_VALID.getCode());
		return authList.stream().map(AuthDTO::getAuth_url).collect(Collectors.toList());
	}
	
	/**
	 * 获取角色对应的所有的目录
	 */
	@Override
	public List<MenuResponseVO> getMenuByRoleId(HttpServletRequest request) {
		UserInfoDTO user = UserUtils.getUser(request);
		List<Menu> menuList = menuResitory.findByRoleIdAndDeleteFlag(user.getRoleId(),SysDicEnum.SYS_VALID.getCode());
		return getMenuVOByMenu(menuList,Long.valueOf(SysDicEnum.SYS_PARENT_MENU.getCode()));
	}
	
	/**
	 * 
	* @Description:（递归查询出所有的目录并封装的方法） 
	* 方法返回值: @param menuList
	* 方法返回值: @param pid
	* 方法返回值: @return
	 */
	private static List<MenuResponseVO> getMenuVOByMenu(List<Menu> menuList,Long pid){
		List<MenuResponseVO> result = new ArrayList<MenuResponseVO>();
		for(Menu indexMenu : menuList) {
			//首先拿到所有Pid为传入pid的值节点
			if(indexMenu.getPid()==pid) {
				MenuResponseVO menuResponseVO = new MenuResponseVO();
				menuResponseVO.setId(indexMenu.getId());
				menuResponseVO.setName(indexMenu.getMenuName());
				menuResponseVO.setUrl(indexMenu.getMenuName());
				result.add(menuResponseVO);
			}
		}
		for (MenuResponseVO menuResponseVO : result) {
			menuResponseVO.setSonMenu(getMenuVOByMenu(menuList, menuResponseVO.getId()));
		}
		return result;
	}
	
	
	
//	public static void main(String[] args) throws Exception {
//		List<Menu> menuList = new ArrayList<>();
//		menuList.add(new Menu(1l,0l,"首页","url",1l));
//		menuList.add(new Menu(2l,0l,"贷款","url",1l));
//		menuList.add(new Menu(3l,1l,"首页--子节点1","url",1l));
//		menuList.add(new Menu(4l,1l,"首页--子节点2","url",1l));
//		menuList.add(new Menu(5l,1l,"首页--子节点3","url",1l));
//		menuList.add(new Menu(6l,2l,"贷款--子节点1","url",1l));
//		menuList.add(new Menu(7l,2l,"贷款--子节点2","url",1l));
//		menuList.add(new Menu(8l,3l,"首页--子节点1--子节点1","url",1l));
//		menuList.add(new Menu(9l,0l,"管理","url",1l));
//		menuList.add(new Menu(10l,9l,"管理--子节点1","url",1l));
//		menuList.add(new Menu(11l,10l,"管理--子节点1--子节点1","url",1l));
//		menuList.add(new Menu(12l,4l,"首页--子节点2---子节点1","url",1l));
//		menuList.add(new Menu(13l,5l,"首页--子节点3---子节点1","url",1l));
//		menuList.add(new Menu(14l,6l,"贷款--子节点1---子节点1","url",1l));
//		List<MenuResponseVO> menu = new ArrayList<MenuResponseVO>();
//		List<Long> collect = menuList.stream().map(Menu::getPid).collect(Collectors.toList());
//		Long max = java.util.Collections.max(collect);
//		Long id = 0l;
//		for(Menu index : menuList) {
//			if(index.getPid()==max) {
//				id = index.getId();
//			}
//		}
//		List<MenuResponseVO> menuVOByMenu = getMenuVOByMenu(menuList,0l);
//		String objectToJson = JsonUtil.objectToJson(menuVOByMenu);
//		System.out.println(objectToJson);
//	}
}