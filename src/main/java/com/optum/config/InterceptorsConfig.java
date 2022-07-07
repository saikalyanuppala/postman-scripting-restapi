package com.optum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.optum.interceptors.BookHandlerInterceptor;

@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {

	@Autowired
	private BookHandlerInterceptor interceptor;


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}
}
