package com.kdt.controllers;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kdt.dto.MailDTO;
import com.kdt.dto.Mail_FileDTO;
import com.kdt.services.MailService;
import com.kdt.services.Mail_FileService;

@RestController
@RequestMapping("/api/Mails")		
public class MailController {

	@Autowired
	private MailService service;

	@Autowired
	private Mail_FileService fservice;

	@PostMapping()
	public ResponseEntity<String> post(@RequestParam String title, @RequestParam String sender, @RequestParam String receipt, @RequestParam(required = false) MultipartFile[] files, @RequestParam String contents) throws Exception {
	    System.out.println(title + " : " + sender + " : " + contents + " : " + receipt);

	    MailDTO dto = new MailDTO();
	    dto.setSender(sender);
	    dto.setReceipient(receipt);
	    dto.setTitle(title);
	    dto.setContents(contents);

	    dto = service.addMail(dto);
	    int seq = dto.getSeq();

	    String upload = "c:/uploads";
	    File uploadPath = new File(upload);

	    if (!uploadPath.exists()) {
	        uploadPath.mkdirs();
	    }

	    if (files != null && files.length > 0) {
	        for (MultipartFile file : files) {
	            System.out.println(file.getOriginalFilename());
	            String oriName = file.getOriginalFilename();
	            String sysName = UUID.randomUUID() + "_" + oriName;

	            file.transferTo(new File(uploadPath, sysName));

	            Mail_FileDTO fdto = new Mail_FileDTO();
	            fdto.setOri_name(oriName);
	            fdto.setSys_name(sysName);
	            fdto.setParent_seq(seq);
	            fservice.insert(fdto);
	        }
	    }

	    return ResponseEntity.ok("");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/inbox")
	public ResponseEntity<List<MailDTO>> selectMailAll() {
		List<MailDTO> recent = service.selectAll();
		return ResponseEntity.ok(recent);
	}

	@GetMapping("/send")
	public ResponseEntity<List<MailDTO>> selectAllSend() {
		List<MailDTO> Com = service.selectAllSend();
		return ResponseEntity.ok(Com);
	}

	@GetMapping("/temp")
	public ResponseEntity<List<MailDTO>> selectAllTemp() {
		List<MailDTO> ComFree = service.selectAllTemp();
		return ResponseEntity.ok(ComFree);
	}

	@GetMapping("/spam")
	public ResponseEntity<List<MailDTO>> selectAllSpam() {
		List<MailDTO> Dept = service.selectAllSpam();
		return ResponseEntity.ok(Dept);
	}

	@GetMapping("/tome")
	public ResponseEntity<List<MailDTO>> selectAllToMe() {
		List<MailDTO> DeptFree = service.selectAllToMe();
		return ResponseEntity.ok(DeptFree);
	}

	@GetMapping("/{seq}")
	public ResponseEntity <MailDTO> selectMailBySeq(@PathVariable Integer seq) {
		MailDTO message = service.selectBySeq(seq);
		return ResponseEntity.ok(message);
	}

	@DeleteMapping("/{seq}")
	public ResponseEntity<String> deleteInbox(@PathVariable Integer seq) {
		service.deleteInbox(seq);
		return ResponseEntity.ok("삭제 성공!");
	}
	
	@DeleteMapping("/{seq}")
	public ResponseEntity<String> deleteSent(@PathVariable Integer seq) {
		service.deleteSent(seq);
		return ResponseEntity.ok("삭제 성공!");
	}

	@GetMapping("/update/{seq}")
	public ResponseEntity <MailDTO> selectUPdateMailBySeq(@PathVariable Integer seq) {
		MailDTO message = service.selectBySeq(seq);
		return ResponseEntity.ok(message);
	}

	@PutMapping("/update/{seq}")
	public ResponseEntity<Void> updateMail(@PathVariable Integer seq,@RequestPart("title") String title,@RequestPart("contents") String contents,@RequestPart("category") String category,@RequestPart(value = "files", required = false) MultipartFile[] files) throws Exception{

		MailDTO dto = new MailDTO();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContents(contents);

		service.updateMail(dto);

	    String upload = "c:/uploads";
	    File uploadPath = new File(upload);

	    if (!uploadPath.exists()) {
	        uploadPath.mkdirs();
	    }

	    if (files != null && files.length > 0) {
	        for (MultipartFile file : files) {
	            System.out.println(file.getOriginalFilename());
	            String oriName = file.getOriginalFilename();
	            String sysName = UUID.randomUUID() + "_" + oriName;

	            file.transferTo(new File(uploadPath, sysName));

	            Mail_FileDTO fdto = new Mail_FileDTO();
	            fdto.setOri_name(oriName);
	            fdto.setSys_name(sysName);
	            fdto.setParent_seq(seq); // 게시물의 seq를 parent_seq로 설정
	            fservice.insert(fdto);
	        }
	    }

		return ResponseEntity.ok().build();
	}


}
