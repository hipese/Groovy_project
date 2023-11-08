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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kdt.dto.MailDTO;
import com.kdt.dto.MailReceiptDTO;
import com.kdt.dto.Mail_FileDTO;
import com.kdt.services.MailService;
import com.kdt.services.Mail_FileService;

@RestController
@RequestMapping("/api/mails")		
public class MailController {

	@Autowired
	private MailService service;

	@Autowired
	private Mail_FileService fservice;

	@PostMapping()
	public ResponseEntity<String> post(@RequestParam String title, @RequestParam String sender, @RequestParam String receipient, @RequestParam(required = false) MultipartFile[] files, @RequestParam String contents) throws Exception {
		System.out.println(title + " : " + sender + " : " + contents + " : " + receipient);

		MailDTO dto = new MailDTO();
		dto.setSender(sender);
		dto.setReceipient(receipient);
		dto.setTitle(title);
		dto.setContents(contents);
		dto = service.addMail(dto);

		int seq = dto.getSeq();

		MailReceiptDTO Rdto = new MailReceiptDTO();
		Rdto.setSender(receipient);
		Rdto.setReceipient(sender);
		Rdto.setParent_seq(seq);

		Rdto = service.insertReceipt(Rdto);

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

	@GetMapping("/{seq}")
	public ResponseEntity <MailDTO> selectMailBySeq(@PathVariable Integer seq) {
		MailDTO mail = service.selectBySeq(seq);
		return ResponseEntity.ok(mail);
	}

	@GetMapping("/waste/inbox")
	public ResponseEntity<List<MailDTO>> selectDelInbox() {
		List<MailDTO> inbox = service.selectDelInbox();
		return ResponseEntity.ok(inbox);
	}

	@GetMapping("/waste/send")
	public ResponseEntity<List<MailReceiptDTO>> selectDelSent() {
		List<MailReceiptDTO> send = service.selectDelSent();
		return ResponseEntity.ok(send);
	}

	@GetMapping("/inbox")
	public ResponseEntity<List<MailDTO>> selectMailAll() {
		List<MailDTO> inbox = service.selectAll();
		return ResponseEntity.ok(inbox);
	}

	@GetMapping("/send")
	public ResponseEntity<List<MailDTO>> selectAllSend() {
		List<MailDTO> Send = service.selectAllSend();
		return ResponseEntity.ok(Send);
	}

	@GetMapping("/temp")
	public ResponseEntity<List<MailDTO>> selectAllTemp() {
		List<MailDTO> Temp = service.selectAllTemp();
		return ResponseEntity.ok(Temp);
	}

	@GetMapping("/spam")
	public ResponseEntity<List<MailDTO>> selectAllSpam() {
		List<MailDTO> Spam = service.selectAllSpam();
		return ResponseEntity.ok(Spam);
	}

	@GetMapping("/tome")
	public ResponseEntity<List<MailDTO>> selectAllToMe() {
		List<MailDTO> ToMe = service.selectAllToMe();
		return ResponseEntity.ok(ToMe);
	}

	@PutMapping("/inbox/{seq}")
	public ResponseEntity<String> updateInbox(@PathVariable Integer seq) {
		service.updateInbox(seq);
		return ResponseEntity.ok("");
	}

	@PutMapping("/inbox/{seq}")
	public ResponseEntity<String> updateSent(@PathVariable Integer seq) {
		service.updateSent(seq);
		return ResponseEntity.ok("");
	}

	@DeleteMapping("/inbox/{seq}")
	public ResponseEntity<String> deleteInbox(@PathVariable Integer seq) {
		service.deleteInbox(seq);
		return ResponseEntity.ok("");
	}

	@DeleteMapping("/sent/{seq}")
	public ResponseEntity<String> deleteSent(@PathVariable Integer seq) {
		service.deleteSent(seq);
		return ResponseEntity.ok("");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
