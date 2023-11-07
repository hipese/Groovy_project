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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kdt.dto.BoardDTO;
import com.kdt.services.BoardService;

@RestController
@RequestMapping("/api/boards")		
public class BoardController {

	@Autowired
	private BoardService service;

	@PostMapping()
	public ResponseEntity<String>post(@RequestParam String title, String writer, @RequestParam(required = false) MultipartFile[] files, @RequestParam String contents, @RequestParam String category) throws Exception{
		System.out.println(title + " : " + writer + " : " + contents + " : " + category);

		String upload = "c:/uploads";
		File uploadPath = new File(upload);

		if(!uploadPath.exists()) {
			uploadPath.mkdir();
		}

		if (files != null && files.length > 0) {
			for(MultipartFile file:files) {
				System.out.println(file.getOriginalFilename());
				String oriName = file.getOriginalFilename();
				String sysName = UUID.randomUUID()+"_"+oriName;

				file.transferTo(new File(uploadPath,sysName));
			}
			// file db에 넣는 작업
		}

		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContents(contents);
		dto.setCategory(category);

		service.addBoard(dto);
		System.out.println("DB 성공!");

		return ResponseEntity.ok("완전 성공!");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/recent")
	public ResponseEntity<List<BoardDTO>> selectBoardRecent() {
		List<BoardDTO> recent = service.selectBoardRecent();
		return ResponseEntity.ok(recent);
	}

	@GetMapping("/com")
	public ResponseEntity<List<BoardDTO>> selectBoardAllCom() {
		List<BoardDTO> Com = service.selectBoardAllCom();
		return ResponseEntity.ok(Com);
	}
	
	@GetMapping("/comfree")
	public ResponseEntity<List<BoardDTO>> selectBoardAllComFree() {
		List<BoardDTO> ComFree = service.selectBoardAllComFree();
		return ResponseEntity.ok(ComFree);
	}
	
	@GetMapping("/dept")
	public ResponseEntity<List<BoardDTO>> selectBoardAllDept() {
		List<BoardDTO> Dept = service.selectBoardAllDept();
		return ResponseEntity.ok(Dept);
	}

	@GetMapping("/deptfree")
	public ResponseEntity<List<BoardDTO>> selectBoardAllDeptFree() {
		List<BoardDTO> DeptFree = service.selectBoardAllDeptFree();
		return ResponseEntity.ok(DeptFree);
	}

	@GetMapping("/{seq}")
	public ResponseEntity <BoardDTO> selectBoardBySeq(@PathVariable Integer seq) {
		BoardDTO message = service.selectBoardBySeq(seq);
		return ResponseEntity.ok(message);
	}

	@DeleteMapping("/{seq}")
	public ResponseEntity<String> deleteBoard(@PathVariable Integer seq) {
		service.deleteBoard(seq);
		return ResponseEntity.ok("삭제 성공!");
	}

	@PutMapping("/{seq}")
	public ResponseEntity<Void> updateBoard(@PathVariable Integer seq, @RequestBody BoardDTO dto) {
		dto.setSeq(seq);
		service.updateBoard(dto);
		return ResponseEntity.ok().build();
	}

}
