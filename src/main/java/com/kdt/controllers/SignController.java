package com.kdt.controllers;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kdt.dto.Sign_documentDTO;
import com.kdt.dto.Sign_filesDTO;
import com.kdt.services.Sign_documentService;
import com.kdt.services.Sign_filesService;

@RestController
@RequestMapping("/api/signlist")
public class SignController {

	@Autowired
	Sign_documentService signservice;

	@Autowired
	Sign_filesService sfservice;

	@PostMapping
	public ResponseEntity<String> post(Sign_documentDTO dto, MultipartFile[] files) throws Exception {

		String upload = "c:/uploads";
		File uploadPath = new File(upload);
		if (!uploadPath.exists()) {
			uploadPath.mkdir();
		}

		String document_type = dto.getDocument_type();
		String contents = dto.getContents();
		String recipient = dto.getRecipient();
		int accept = dto.getAccept();
		String title = dto.getTitle();

		int parent_seq = signservice.insert(dto);

		if (files != null) {
			for (MultipartFile file : files) {
				String oriName = file.getOriginalFilename();
				String sysName = UUID.randomUUID() + "_" + oriName;
				file.transferTo(new File(uploadPath + "/" + sysName));
				sfservice.insert(new Sign_filesDTO(0, oriName, sysName, parent_seq));
			}
		}

		return ResponseEntity.ok("완전 성공!"); // 클라이언트에게 http 응답코드 200번대 반환
	}
}
