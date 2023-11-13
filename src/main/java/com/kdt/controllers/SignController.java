package com.kdt.controllers;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kdt.dto.Sign_documentDTO;
import com.kdt.dto.Sign_filesDTO;
import com.kdt.services.Sign_documentService;
import com.kdt.services.Sign_filesService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/signlist")
public class SignController {

	@Autowired
	Sign_documentService signservice;

	@Autowired
	Sign_filesService sfservice;

	@Autowired
	private HttpSession session;

	@PostMapping
	public ResponseEntity<Integer> post(Sign_documentDTO dto, MultipartFile[] files) throws Exception {

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

		return ResponseEntity.ok(parent_seq); // 클라이언트에게 http 응답코드 200번대 반환
	}

	@GetMapping
	public ResponseEntity<List<Sign_documentDTO>> selectProgress() {
		String id = (String) session.getAttribute("loginID");
		List<Sign_documentDTO> list = signservice.selectProgress(id);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/complete")
	public ResponseEntity<List<Sign_documentDTO>> selectComplete() {
		String id = (String) session.getAttribute("loginID");
		List<Sign_documentDTO> list = signservice.selectComplete(id);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/wait")
	public ResponseEntity<List<Sign_documentDTO>> selectWait() {
		String id = (String) session.getAttribute("loginID");
		List<Sign_documentDTO> list = signservice.selectWait(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/vacation_complete")	
	public ResponseEntity<List<Sign_documentDTO>> selectVacationComplete() {
		String id = (String) session.getAttribute("loginID");
		List<Sign_documentDTO> list = signservice.selectVacationComplete(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/vacation_wait")	
	public ResponseEntity<List<Sign_documentDTO>> selectVacationWait() {
		String id = (String) session.getAttribute("loginID");
		List<Sign_documentDTO> list = signservice.selectVacationWait(id);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{seq}")
	public ResponseEntity<Sign_documentDTO> selectBySeq(@PathVariable Integer seq) {
		Sign_documentDTO list = signservice.selectBySeq(seq);
		return ResponseEntity.ok(list);
	}

	@PutMapping("/accept/{seq}")
	public ResponseEntity<Integer> update(@PathVariable Integer seq, @RequestBody Sign_documentDTO dto) {
		dto.setSeq(seq);
		signservice.accept(dto);
		return ResponseEntity.ok(seq);
	}

	@PutMapping("/reject/{seq}")
	public ResponseEntity<Integer> reject(@PathVariable Integer seq, @RequestBody Sign_documentDTO dto) {
		signservice.reject(dto);
		return ResponseEntity.ok(seq);
	}

}
