package com.kdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.Sign_documentDTO;
import com.kdt.services.Sign_documentService;

@RestController
@RequestMapping("/api/messages")
public class SignController {

	@Autowired
	Sign_documentService sd_serService;

	@PostMapping
	public ResponseEntity<String> post(@RequestBody Sign_documentDTO signData) throws Exception {

		String docType = signData.getDocument_type();
		String writer = signData.getWriter();
		String title = signData.getTitle();
		// 그 외 다른 필요한 데이터 처리

		// 데이터를 로깅하거나 다른 작업을 수행
		System.out.println("문서종류: " + docType);
		System.out.println("기안작성자: " + writer);
		System.out.println("제목: " + title);

		return ResponseEntity.ok("완전 성공!"); // 클라이언트에게 http 응답코드 200번대 반환
	}
}
