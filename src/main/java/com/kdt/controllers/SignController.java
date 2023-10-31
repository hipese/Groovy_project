package com.kdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kdt.services.Sign_documentService;

@Controller
public class SignController {
	
	@Autowired
	Sign_documentService sd_serService;
	
}
