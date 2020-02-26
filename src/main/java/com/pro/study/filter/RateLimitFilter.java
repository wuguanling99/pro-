package com.pro.study.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.util.concurrent.RateLimiter;

/** 
* @author: wgl
* @date: 2020年2月23日下午9:40:00 
* @version:1.0
* @Description: 限制流量控制 
*/
@Order(1)
@Component
public class RateLimitFilter extends OncePerRequestFilter{
	
	
	//设置每秒只允许1个请求
	private RateLimiter rateLimter = RateLimiter.create(10);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("流浪控制拦截");
		//如果是滿足限流器流量
		if(rateLimter.tryAcquire()) {
			//這裡是滿足流量控制 及 沒有達到控制數
			//放行
			filterChain.doFilter(request, response);
		}else {//如果不滿足流量
			//如果超過了流量控制數目----429狀態碼
			response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
			//限流以後的相應 我們顯示to many request
			response.getWriter().write("to many request");
			response.getWriter().flush();
			return;
		}
	}
}
