package com.kdt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientRoutingController {
	
	// ViewResolver에 거치지 않고 Forward 방식으로 return
//	@RequestMapping("/**")
//	public String route(HttpServletRequest request) {
//		System.out.println("ClientRoutingController Activated");
//		if(!request.getRequestURI().endsWith("index.html")) {
//			return "forward:/index.html"; 
//		}
//		
//		return ""; 
//	}
//	@ResponseBody
//	@RequestMapping("/ws-message/**")
//	public void abc() { 
//	}
	

	//@RequestMapping({ "/", "/{path:^(ws-message$|ws-message/.*|\\.[^.]*$)[^\\.]*}", "/**/{path:^(ws-message$|ws-message/.*|\\.[^.]*$)[^\\.]*}" })
	@RequestMapping({"/",""})
	public String forwardToIndex() {
		System.out.println("ClientRoutingController Activated");
		return "forward:/index.html";
	}
	
}
