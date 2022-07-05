package com.optum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.optum.interceptors.BookHandlerInterceptor;
import com.optum.interceptors.BookHandlerInterceptor2;

@Component
public class WebAppConfiguration implements WebMvcConfigurer {

	@Autowired
	private BookHandlerInterceptor interceptor;

	@Autowired
	private BookHandlerInterceptor2 interceptor2;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
		registry.addInterceptor(interceptor2);
	}
}
