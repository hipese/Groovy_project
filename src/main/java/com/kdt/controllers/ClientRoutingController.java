package com.kdt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ClientRoutingController {
	
	// ViewResolver에 거치지 않고 Forward 방식으로 return
	@RequestMapping("/**")
	public String route(HttpServletRequest request) {
		System.out.println("ClientRoutingController Activated");
		if(!request.getRequestURI().endsWith("index.html")) {
			return "forward:/index.html"; 
		}
		
		return ""; 
	}
	
}
