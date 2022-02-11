package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		//로그인했는지 파악하기 위하여 request객체를 통하여 세션을 갖고 와서 
		//세션에 userID가 있는지 파악합니다.
		
		HttpSession session= request.getSession();
		String userID = (String)session.getAttribute("userID");
		
		//만약 로그인했다면 요청한 서비스로 이동
		if(userID != null) {
			return super.preHandle(request, response, handler);
		}else {
			//그렇지 않다면 로그인 페이지로 이동하기
			response.sendRedirect("/login");
			return false;
		}
	}	
}

















