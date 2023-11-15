package com.kdt.controllers;

import java.util.List;

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

import com.kdt.dto.DReplyWithMemberDTO;
import com.kdt.dto.DeptReplyDTO;
import com.kdt.dto.ReplyDTO;
import com.kdt.dto.ReplyWithMemberDTO;
import com.kdt.services.ReplyService;

@RestController
@RequestMapping("/api/reply")		
public class ReplyController {

	@Autowired
	private ReplyService service;

	@PostMapping()
	public ResponseEntity<String> insert(@RequestParam int parent_seq, @RequestParam String writer, @RequestParam String contents) throws Exception {

		ReplyDTO dto = new ReplyDTO();
		dto.setParent_seq(parent_seq);
		dto.setWriter(writer);
		dto.setContents(contents);
		dto = service.insert(dto);

		return ResponseEntity.ok("");
	}

	@PostMapping("/dept")
	public ResponseEntity<String> insertDept(@RequestParam int parent_seq, @RequestParam String writer, @RequestParam String contents) throws Exception {

		DeptReplyDTO dto = new DeptReplyDTO();
		dto.setParent_seq(parent_seq);
		dto.setWriter(writer);
		dto.setContents(contents);
		dto = service.insertDept(dto);

		return ResponseEntity.ok("");
	}

	@GetMapping("/com/{parent_seq}")
	public ResponseEntity <List<ReplyWithMemberDTO>> selectBySeq(@PathVariable Integer parent_seq) {
		List<ReplyWithMemberDTO> reply = service.selectBySeq(parent_seq);
		return ResponseEntity.ok(reply);
	}

	@GetMapping("/dept/{parent_seq}")
	public ResponseEntity <List<DReplyWithMemberDTO>> selectDeptBySeq(@PathVariable Integer parent_seq) {
		List<DReplyWithMemberDTO> reply = service.selectDeptBySeq(parent_seq);
		return ResponseEntity.ok(reply);
	}

	@DeleteMapping("/com/{seq}")
	public ResponseEntity<String> delete(@PathVariable Integer seq) {
		service.delete(seq);
		return ResponseEntity.ok("삭제 성공!");
	}

	@DeleteMapping("/dept/{seq}")
	public ResponseEntity<String> deleteDept(@PathVariable Integer seq) {
		service.deleteDept(seq);
		return ResponseEntity.ok("삭제 성공!");
	}

	@GetMapping("/update/{seq}")
	public ResponseEntity <List<ReplyWithMemberDTO>> selectUPdateBoardBySeq(@PathVariable Integer seq) {
		List<ReplyWithMemberDTO> message = service.selectBySeq(seq);
		return ResponseEntity.ok(message);
	}

	@GetMapping("/updateDept/{seq}")
	public ResponseEntity <List<DReplyWithMemberDTO>> selectUpdateDeptBySeq(@PathVariable Integer seq) {
		List<DReplyWithMemberDTO> message = service.selectDeptBySeq(seq);
		return ResponseEntity.ok(message);
	}

	@PutMapping("/update/{seq}")
	public ResponseEntity<Void> update(@PathVariable Integer seq, @RequestParam String contents) throws Exception{
		System.out.println(seq+contents);
		ReplyDTO dto = new ReplyDTO();
		dto.setContents(contents);
		dto.setSeq(seq);

		service.update(dto);
		System.out.println("됐다");

		return ResponseEntity.ok().build();
	}

	@PutMapping("/updateDept/{seq}")
	public ResponseEntity<Void> updateDept(@PathVariable Integer seq, @RequestParam String contents) throws Exception{

		DeptReplyDTO dto = new DeptReplyDTO();
		dto.setSeq(seq);
		dto.setContents(contents);

		service.updateDept(dto);

		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
