package com.pro.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pro.study.interceptor.AuthInterceptor;
import com.pro.study.interceptor.RSAKeyInterceptor;

/**
 * @author: wgl
 * @date: 2020年2月23日下午10:59:16
 * @version:1.0
 * @Description: 管理所有的interceptor
 */
@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {

	@Autowired
	private RSAKeyInterceptor rsaKeyInterceptor;
	@Autowired
	private AuthInterceptor authInterceptor;
	
	/**
	 * 先添加的先执行后添加的后执行
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(rsaKeyInterceptor);
		registry.addInterceptor(authInterceptor);
	}
}
