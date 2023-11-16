package com.kdt.controllers;

import java.io.File;
import java.sql.Timestamp;
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

import com.kdt.dto.AttendenceDTO;
import com.kdt.dto.Sign_documentDTO;
import com.kdt.dto.Vacation_documentDTO;
import com.kdt.dto.Vacation_filesDTO;
import com.kdt.services.AttendenceService;
import com.kdt.services.Vacation_documentService;
import com.kdt.services.Vacation_filesService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/attend")
public class AttendenceController {
	
	@Autowired
	private HttpSession session;

	@Autowired
	private AttendenceService AtdService;
	
	@Autowired
	private Vacation_documentService vdService;
	
	@Autowired
	Vacation_filesService vfservice;
	
	@PostMapping
	public ResponseEntity<Integer> post(Vacation_documentDTO dto, MultipartFile[] files) throws Exception {

		String upload = "c:/vdocument";
		File uploadPath = new File(upload);
		if (!uploadPath.exists()) {
			uploadPath.mkdir();
		}

		String document_type = dto.getDocument_type();
		String contents = dto.getContents();
		String recipient = dto.getRecipient();
		int accept = dto.getAccept();
		String title = dto.getTitle();
		Timestamp startDate = dto.getStartDate();
		Timestamp endDate = dto.getEndDate();
		int total_date = dto.getTotal_date();

		int parent_seq = vdService.insert(dto);

		if (files != null) {
			for (MultipartFile file : files) {
				String oriName = file.getOriginalFilename();
				String sysName = UUID.randomUUID() + "_" + oriName;
				file.transferTo(new File(uploadPath + "/" + sysName));
				vfservice.insert(new Vacation_filesDTO(0, oriName, sysName, parent_seq));
			}
		}

		return ResponseEntity.ok(parent_seq); // 클라이언트에게 http 응답코드 200번대 반환
	}
	
	@GetMapping("/vacation_complete")	
	public ResponseEntity<List<Vacation_documentDTO>> selectVacationComplete() {
		String id = (String) session.getAttribute("loginID");
		List<Vacation_documentDTO> list = vdService.selectVacationComplete(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/vacation_progress")	
	public ResponseEntity<List<Vacation_documentDTO>> selectVacationWait() {
		String id = (String) session.getAttribute("loginID");
		List<Vacation_documentDTO> list = vdService.selectVacationWait(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/vacation_wait")	
	public ResponseEntity<List<Vacation_documentDTO>> selectVacationProgress() {
		String id = (String) session.getAttribute("loginID");
		List<Vacation_documentDTO> list = vdService.selectVacationProgress(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping
	public ResponseEntity<List<AttendenceDTO>> selectByID() {
		String id = (String)session.getAttribute("loginID");
		System.out.println(id);
		List<AttendenceDTO> list = AtdService.selectByID(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{seq}")
	public ResponseEntity<Vacation_documentDTO> selectBySeq(@PathVariable Integer seq) {
		Vacation_documentDTO list = vdService.selectBySeq(seq);
		return ResponseEntity.ok(list);
	}

	@PutMapping("/accept/{seq}")
	public ResponseEntity<Integer> update(@PathVariable Integer seq, @RequestBody Vacation_documentDTO dto) {
		dto.setSeq(seq);
		vdService.accept(dto);
		return ResponseEntity.ok(seq);
	}

	@PutMapping("/reject/{seq}")
	public ResponseEntity<Integer> reject(@PathVariable Integer seq, @RequestBody Vacation_documentDTO dto) {
		vdService.reject(dto);
		return ResponseEntity.ok(seq);
	}
}
