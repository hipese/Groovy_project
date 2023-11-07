package com.kdt.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kdt.dto.MemberDTO;
import com.kdt.services.MemberService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	MemberService mservice;

	@Autowired
	HttpSession session;

	@GetMapping
	public ResponseEntity<MemberDTO> memberProfile() {
		String id = (String) session.getAttribute("loginID");
		System.out.println("로그인 한놈은 누구인가?" + id);

		MemberDTO dto = mservice.getprofile(id);
		System.out.println(dto.getContact() + " : " + dto.getGroup_name() + " : " + dto.getPosition());
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<String> updateImage(@RequestParam("cfile") MultipartFile cfile) throws Exception {
		
		String id = (String) session.getAttribute("loginID");
		System.out.println("변경할 이미지 뭐로옴?:" + cfile.getName());

		mservice.updateImage(id, cfile.getName());
		
		
		String fileName = StringUtils.cleanPath(cfile.getOriginalFilename());

		Path storageLocation = Paths.get("C:\\ReactWorkSpace\\groovy\\src\\assets");
		
		try {
			if (cfile.isEmpty()) {
				throw new Exception("Failed to store empty file " + fileName);
			}
			// 파일의 경로를 생성합니다.
			Path destinationFile = storageLocation.resolve(Paths.get(fileName)).normalize().toAbsolutePath();
			// 파일을 저장합니다.
			Files.copy(cfile.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
			return ResponseEntity.ok("File uploaded successfully: " + fileName);
		} catch (IOException e) {
			throw new Exception("Failed to store file " + fileName, e);
		}
		
	}

}
