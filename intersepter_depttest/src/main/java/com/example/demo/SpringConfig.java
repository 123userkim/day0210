package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//interceptor 등록하기 위해서 WebMvcConfigurer확장하기
public class SpringConfig implements WebMvcConfigurer{

	@Override //addInterceptors오버라이딩
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
		
		//매개변수 registry를 통해서 인터셉트를 등록함
 		registry.addInterceptor(new LoginInterceptor())
 		//insertDept.do에 대한 요청일 때 인터셉트 동작
		.addPathPatterns("/insertDept.do","/member/**");
 		
 		registry.addInterceptor(new AdminInterceptor())
 		.addPathPatterns("/admin/**");
 		
 		registry.addInterceptor(new DeptLogInterceptor())
 		.addPathPatterns("/**")
 		.excludePathPatterns("/login");
	}
}
