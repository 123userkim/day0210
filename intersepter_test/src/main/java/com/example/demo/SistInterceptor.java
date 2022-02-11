package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class SistInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		Thread.sleep(500);
		System.out.println("요청처리 전입니다.");
		Thread.sleep(500);
		
		//사용자의 상황에 따라 흐름을 제어하는 용도로 인터셉터를 사용한다면
		//사용자의 요청으로 이동시키지 않으려면 false를 반환
		//사용자의 요청으로 이동시키려면 다음의 메소드를 반환함
		//매개변수 request를 통해서 사용자의 정보를 파악할 수 있음
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		Thread.sleep(500);
		System.out.println("요청 메소드 전입니다.");
		Thread.sleep(500);
		super.postHandle(request, response, handler, modelAndView);
	}
	
	//뷰로 이동하기 직전에 동작하는 메소드
	//흐름을 제어하는 용도로 사용하기엔 
	//이미 요청에 따른 컨트롤러의 메소드안에 내용은 모두 수행
	//만약, log를 남기는 용도로 인터셉트를 사용한다면 ㄱㅊ but 흐름제어 ->preHandle사용
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("view로 가기 전입니다.");
		Thread.sleep(1000);
		super.afterCompletion(request, response, handler, ex);
	}
	
}
