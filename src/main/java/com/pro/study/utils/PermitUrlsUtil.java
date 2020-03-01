package com.pro.study.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.pro.study.enums.SysRoleEnum;
import com.pro.study.vo.response.user.UserInfoVO;

/** 
* @author: wgl
* @date: 2020年2月23日下午9:51:34 
* @version:1.0
* @Description: 所有可以放行的url枚举类
*/
@Component
public class PermitUrlsUtil {
	
	private static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        PermitUrlsUtil.redisTemplate = redisTemplate;
    }
	
	
	//不需要权限认证可以直接放行的接口
	private static List<String>  passUrlList = new ArrayList<String>();
	
	//角色set可以访问的接口---查询出数据库里所有的角色保存在这里
	private static Map<String,List<String>> roleUrlList = new HashMap<String,List<String>>();
	
	//不需要解密的url
	private static List<String>  dontNeedDecryptList = new ArrayList<String>();
	
	//需要解密的url
	private static List<String>  needDecryptList = new ArrayList<String>();
	
	
	/**
	 * 
	* @Description:（是否是需要解密的url） 
	* 方法返回值: @param url
	* 方法返回值: @return
	 */
	public static boolean hasNeedDecryPermitUrls(String url) {
		if(ArrayUtils.contains(needDecryptList.toArray(), url)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	* @Description:（是否是不需要解密的url） 
	* 方法返回值: @param url
	* 方法返回值: @return
	 */
	public static boolean hasDontNeedDecryPermitUrls(String url) {
		if(ArrayUtils.contains(dontNeedDecryptList.toArray(), url)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	* @Description:（是否是不可以直接放行的url） 
	* 方法返回值: @param url
	* 方法返回值: @return
	 */
	public static boolean hasPassUrls(String url) {
		if(ArrayUtils.contains(passUrlList.toArray(), url)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 
	* @Description:（封装静态roleUrlList资源的方法--所有角色和角色对应的url） 
	* 方法返回值: @param roleUrlList
	 */
	public static void setRoleUrls(Map<String, List<String>> authUrlList) {
		roleUrlList = authUrlList;
	}
	
	/**
	 * 
	* @Description:（封装静态资源的方法） 
	* 方法返回值: @param roleUrlList
	 */
	public static void setDontNeedDecryptList(List<String> roleUrlList) {
		dontNeedDecryptList = roleUrlList;
	}
	
	/**
	 * 
	* @Description:（封装静态资源的方法） 
	* 方法返回值: @param roleUrlList
	 */
	public static void setNeedDecryptList(List<String> roleUrlList) {
		needDecryptList = roleUrlList;
	}

	/**
	 * 
	 * @Description:（接口用户权限认证,最后把用户放到request里） 
	 * 方法返回值: @param requestURI
	 * 方法返回值: @param token
	 * 方法返回值: @return
	 */
	public static boolean authCheck(String requestURI, String token, HttpServletRequest request) {
		List<String> passRoleList = roleUrlList.get(SysRoleEnum.PASSROLE.getRole());
		if(token==null&&ArrayUtils.contains(passRoleList.toArray(),requestURI)) {
			return true;
		}
		Set<String> roleNameSet = roleUrlList.keySet();
		//解密token----拿到对应的角色信息
		String jwtToken =redisTemplate.opsForValue().get(token).toString();
		UserInfoVO userInfo = JWTUtil.parseJWT(jwtToken);
		String roleName = userInfo.getRole();
		List<String> urlLists = roleUrlList.get(roleName);
		if(ArrayUtils.contains(urlLists.toArray(),requestURI)) {
			return true;
		}
		return false;
	}
	/**
	 * 
	* @Description:（封装所有可以直接通过的url） 
	* 方法返回值: @param roleUrlList2
	 */
	public static void setPassUrls(List<String> passUrls) {
		passUrlList = passUrls;
	}

}
