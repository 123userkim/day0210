package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SistController {
	
	@RequestMapping("/hello")
	public void hello() {	 
		System.out.println("hello의 요청");
	
	}	
	
	@RequestMapping("/list")
	public void list() {		
		System.out.println("list의 요청");
	}		
	
	@RequestMapping("/menu1")
	public void menu1() {		
	}	
	
	@RequestMapping("/menu2")
	public void menu2() {		
	}
}
