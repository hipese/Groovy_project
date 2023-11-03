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
	public ResponseEntity<String>post(String message, MultipartFile[] files) throws Exception{
		System.out.println(message);

		String upload = "c:/uploads";
		File uploadPath = new File(upload);

		if(!uploadPath.exists()) {
			uploadPath.mkdir();
		}

		for(MultipartFile file:files) {
			System.out.println(file.getOriginalFilename());
			String oriName = file.getOriginalFilename();
			String sysName = UUID.randomUUID()+"_"+oriName;

			file.transferTo(new File(uploadPath,sysName));
		}
		return ResponseEntity.ok("완전 성공!");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping
	public ResponseEntity<List<BoardDTO>> selectBoardAll() {
		List<BoardDTO> Board = service.selectBoardAll();
		System.out.println(Board);
		return ResponseEntity.ok(Board);
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
		// 게시판같은 경우 많은 사람이 사용하니까 db에서 가져오고 어쩌고 복잡해짐
	}

}
