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
	public ResponseEntity<String>post(@RequestParam String title, String writer, MultipartFile[] files, @RequestParam String contents) throws Exception{
		System.out.println(title + " : " + writer+ " : " + contents);

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
		
		BoardDTO dto = new BoardDTO();
	    dto.setTitle(title);
	    dto.setWriter(writer);
	    dto.setContents(contents);

		service.addBoard(dto);
		System.out.println("DB 성공!");

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
	}

}
