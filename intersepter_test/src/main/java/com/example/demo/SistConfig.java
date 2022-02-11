package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SistConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
		
		//hello,list라는 요청에 대해서 SistInterceptor의 환경을 적용 :  인터셉터 동작
		registry.addInterceptor(new SistInterceptor())
		.addPathPatterns("/hello","/list","/member/**","/shop/**")
		.excludePathPatterns("/member/menu3","/shop/image/**");	//제외시키고자하는 서비스 
	 	
	}
}
