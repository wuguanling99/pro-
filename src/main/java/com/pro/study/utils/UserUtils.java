package com.pro.study.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.exception.UserInfoErrorException;

/**
 * 
* @author: wgl
* @date: 2020年3月2日下午3:04:20 
* @version:1.0
* @Description:获取用户信息的工具类
 */
@Component
public class UserUtils {

	private static RedisTemplate redisTemplate;
	
	@Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
		UserUtils.redisTemplate = redisTemplate;
    }
	
	/**
	 * 
	* @Description:（根据request获取用户的方法） 
	* 方法返回值: @param request
	 */
	public static UserInfoDTO getUser(HttpServletRequest request) {
		try {
			String token = request.getHeader("token").toString();
			String jwtToken =redisTemplate.opsForValue().get(token).toString();
			UserInfoDTO userInfo = JWTUtil.parseJWT(jwtToken);
			return userInfo;
		}catch (Exception e) {
			throw new UserInfoErrorException();
		}
	}
}
