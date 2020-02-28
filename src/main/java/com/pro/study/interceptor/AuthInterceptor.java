package com.pro.study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pro.study.utils.PermitUrlsUtil;

/**
 * @author: wgl
 * @date: 2020年2月23日下午1:28:55
 * @version:1.0
 * @Description: 权限拦截器
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	
	/**
	 * 1)前置权限拦截器
	 * 判断是否具有权限
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		String token = request.getHeader("token");
		//判断是否是需要权限验证的接口
		if(PermitUrlsUtil.authCheck(requestURI,token,request)) {
			//权限认证成功
			return true;
		}else{
			//不是需要权限验证的接口
			//直接放行
			response.setContentType("text/plain");
			response.getWriter().write("need authentication");
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}
	}

}
