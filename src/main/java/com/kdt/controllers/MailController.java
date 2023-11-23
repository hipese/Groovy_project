package com.kdt.controllers;

import java.io.File;
import java.sql.Timestamp;
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
import com.kdt.dto.MailWithMemberDTO;
import com.kdt.dto.Mail_FileDTO;
import com.kdt.dto.RWasteWithMemFileDTO;
import com.kdt.dto.Re_MemberDTO;
import com.kdt.dto.WasteMailDTO;
import com.kdt.dto.WasteRMailDTO;
import com.kdt.dto.WasteWithMemFileDTO;
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

		Timestamp now = new Timestamp(System.currentTimeMillis());

		MailDTO dto = new MailDTO();
		dto.setSender(sender);
		dto.setReceipient(receipient);
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setWrite_date(now);
		dto = service.addMail(dto);

		int seq = dto.getSeq();

		MailReceiptDTO Rdto = new MailReceiptDTO();
		Rdto.setSender(sender);
		Rdto.setReceipient(receipient);
		Rdto.setTitle(title);
		Rdto.setContents(contents);
		Rdto.setParent_seq(seq);
		Rdto.setWrite_date(now);

		Rdto = service.insertReceipt(Rdto);

		String upload = "/home/ubuntu/uploads";
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
				fdto.setFparent_seq(seq);
				fservice.insert(fdto);
			}
		}

		return ResponseEntity.ok("");
	}

	@GetMapping("/{seq}")
	public ResponseEntity <MailWithMemberDTO> selectMailBySeq(@PathVariable Integer seq) {
		MailWithMemberDTO mail = service.selectBySeq(seq);
		return ResponseEntity.ok(mail);
	}

	@GetMapping("/mem/{seq}")
	public ResponseEntity <Re_MemberDTO> selectMember(@PathVariable Integer seq) {
		Re_MemberDTO mail = service.selectMember(seq);
		return ResponseEntity.ok(mail);
	}
	
	@GetMapping("/waste/inbox/{member_id}")
	public ResponseEntity<List<WasteWithMemFileDTO>> selectDelInbox(@PathVariable String member_id) {
		List<WasteWithMemFileDTO> inbox = service.selectDelInbox(member_id);
		return ResponseEntity.ok(inbox);
	}

	@GetMapping("/waste/send/{member_id}")
	public ResponseEntity<List<RWasteWithMemFileDTO>> selectDelSent(@PathVariable String member_id) {
		List<RWasteWithMemFileDTO> send = service.selectDelSent(member_id);
		return ResponseEntity.ok(send);
	}

	@GetMapping("/inbox/{receipient}")
	public ResponseEntity<List<MailWithMemberDTO>> selectMailAll(@PathVariable String receipient) {
		List<MailWithMemberDTO> inbox = service.selectAll(receipient);
		return ResponseEntity.ok(inbox);
	}

	@GetMapping("/send/{sender}")
	public ResponseEntity<List<MailWithMemberDTO>> selectAllSend(@PathVariable String sender) {
		List<MailWithMemberDTO> Send = service.selectAllSend(sender);
		return ResponseEntity.ok(Send);
	}

	@GetMapping("/tome/{sender}")
	public ResponseEntity<List<MailWithMemberDTO>> selectAllToMe(@PathVariable String sender) {
		List<MailWithMemberDTO> ToMe = service.selectAllToMe(sender);
		return ResponseEntity.ok(ToMe);
	}

	@PutMapping("/inbox/{seq}")
	public ResponseEntity<String> updateInbox(@PathVariable Integer seq, @RequestParam String member_id) {
		service.updateInbox(seq);
		
		WasteMailDTO dto = new WasteMailDTO();
		dto.setParent_seq(seq);
		dto.setMember_id(member_id);
		dto = service.insertWaste(dto);
		return ResponseEntity.ok("");
	}

	@PutMapping("/sent/{seq}")
	public ResponseEntity<String> updateSent(@PathVariable Integer seq, @RequestParam String member_id) {
		service.updateSent(seq);
		
		WasteRMailDTO dto = new WasteRMailDTO();
		dto.setParent_seq(seq);
		dto.setMember_id(member_id);
		dto = service.insertRWaste(dto);
		return ResponseEntity.ok("");
	}

	@PutMapping("/read/{seq}")
	public ResponseEntity<String> isRead(@PathVariable Integer seq) {
		service.isRead(seq);
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
