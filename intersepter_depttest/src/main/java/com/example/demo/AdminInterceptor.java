package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session= request.getSession(); //request로 세션변수를 받아옴옴
		String role = (String)session.getAttribute("role");
		
		//만약 로그인했다면 요청한 서비스로 이동
		//role != null 꼭 물어봐야함
		if(role != null && role.equals("admin")) {
			return super.preHandle(request, response, handler);
		}else {
			//그렇지 않다면 로그인페이지로 이동하기
			response.sendRedirect("/login");
			return false;
		}
	}	
}
	

 
