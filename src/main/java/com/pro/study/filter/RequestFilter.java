package com.pro.study.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pro.study.config.ContentCachingRequestWrapper;
import com.pro.study.utils.PermitUrlsUtil;

@Component
@Order(2)
public class RequestFilter extends OncePerRequestFilter {
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		// 判断是否是不需要认证且需要RSA解密的方法
		if (PermitUrlsUtil.hasNeedDecryPermitUrls(requestURI)) {
			// 需要解密 request转换 不需要解密 不转换request
			System.out.println("request拦截器");
			ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(
					(HttpServletRequest) request);
			String body = IOUtils.toString(requestWrapper.getBody(), request.getCharacterEncoding());
			filterChain.doFilter(requestWrapper, response);
		} else {
			// 剩下的接口是不需要解密的接口直接放行
			filterChain.doFilter(request, response);
		}

	}

}