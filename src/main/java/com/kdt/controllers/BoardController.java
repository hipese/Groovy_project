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

import com.kdt.dto.BoardDTO;
import com.kdt.dto.Board_FileDTO;
import com.kdt.dto.DeptBoardDTO;
import com.kdt.dto.DeptBoard_FileDTO;
import com.kdt.services.BoardService;
import com.kdt.services.Board_FileService;

@RestController
@RequestMapping("/api/boards")		
public class BoardController {

	@Autowired
	private BoardService service;

	@Autowired
	private Board_FileService fservice;

	@PostMapping()
	public ResponseEntity<String> insert(@RequestParam String title, @RequestParam String writer, @RequestParam(required = false) MultipartFile[] files, @RequestParam String contents, @RequestParam String category) throws Exception {
	    System.out.println(title + " : " + writer + " : " + contents + " : " + category);

	    BoardDTO dto = new BoardDTO();
	    dto.setTitle(title);
	    dto.setWriter(writer);
	    dto.setContents(contents);
	    dto.setCategory(category);

	    dto = service.insert(dto);
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

	            Board_FileDTO fdto = new Board_FileDTO();
	            fdto.setOri_name(oriName);
	            fdto.setSys_name(sysName);
	            fdto.setParent_seq(seq); // 게시물의 seq를 parent_seq로 설정
	            fservice.insert(fdto);
	        }
	    }

	    return ResponseEntity.ok("");
	}
	
	@PostMapping("/dept")
	public ResponseEntity<String> insertDept(@RequestParam String title, @RequestParam String writer, @RequestParam(required = false) MultipartFile[] files, @RequestParam String contents, @RequestParam String category, @RequestParam String dept) throws Exception {
	    System.out.println(title + " : " + writer + " : " + contents + " : " + category + " : " + dept);

	    DeptBoardDTO dto = new DeptBoardDTO();
	    dto.setTitle(title);
	    dto.setWriter(writer);
	    dto.setContents(contents);
	    dto.setCategory(category);
	    dto.setDept(dept);

	    dto = service.insertDept(dto);
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

	            DeptBoard_FileDTO fdto = new DeptBoard_FileDTO();
	            fdto.setOri_name(oriName);
	            fdto.setSys_name(sysName);
	            fdto.setParent_seq(seq);
	            fservice.insertDept(fdto);
	        }
	    }

	    return ResponseEntity.ok("");
	}

	@GetMapping("/com/{seq}")
	public ResponseEntity <BoardDTO> selectBoardBySeq(@PathVariable Integer seq) {
		BoardDTO message = service.selectBoardBySeq(seq);
		int view_count = message.getView_count() + 1;
		message.setView_count(view_count);

		service.updateViewCount(seq, view_count);
		return ResponseEntity.ok(message);
	}

	// 부서 소식 detail
	@GetMapping("/dept/{seq}")
	public ResponseEntity <DeptBoardDTO> selectDeptBySeq(@PathVariable Integer seq) {
		DeptBoardDTO dept = service.selectDeptBySeq(seq);
		int view_count = dept.getView_count() + 1;
		dept.setView_count(view_count);

		service.updateDeptViewCount(seq, view_count);
		return ResponseEntity.ok(dept);
	}

	@GetMapping("/recent")
	public ResponseEntity<List<BoardDTO>> selectBoardRecent() {
		List<BoardDTO> recent = service.selectBoardRecent();
		return ResponseEntity.ok(recent);
	}
	
	@GetMapping("/recentDept")
	public ResponseEntity<List<DeptBoardDTO>> selectDeptRecent() {
		List<DeptBoardDTO> recent = service.selectDeptRecent();
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

	// 부서 내 소식 - 부서 공지
	@GetMapping("/deptCom/{dept}")
	public ResponseEntity<List<DeptBoardDTO>> selectBoardAllDept(@PathVariable String dept) {
		List<DeptBoardDTO> Dept = service.selectBoardAllDept(dept);
		return ResponseEntity.ok(Dept);
	}

	@GetMapping("/deptfree/{dept}")
	public ResponseEntity<List<DeptBoardDTO>> selectBoardAllDeptFree(@PathVariable String dept) {
		List<DeptBoardDTO> DeptFree = service.selectBoardAllDeptFree(dept);
		return ResponseEntity.ok(DeptFree);
	}

	@DeleteMapping("/com/{seq}")
	public ResponseEntity<String> deleteBoard(@PathVariable Integer seq) {
		service.deleteBoard(seq);
		return ResponseEntity.ok("삭제 성공!");
	}
	
	@DeleteMapping("/dept/{seq}")
	public ResponseEntity<String> deleteDept(@PathVariable Integer seq) {
		service.deleteDept(seq);
		return ResponseEntity.ok("삭제 성공!");
	}

	@GetMapping("/update/{seq}")
	public ResponseEntity <BoardDTO> selectUPdateBoardBySeq(@PathVariable Integer seq) {
		BoardDTO message = service.selectBoardBySeq(seq);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/updateDept/{seq}")
	public ResponseEntity <DeptBoardDTO> selectUpdateDeptBySeq(@PathVariable Integer seq) {
		DeptBoardDTO message = service.selectDeptBySeq(seq);
		return ResponseEntity.ok(message);
	}

	@PutMapping("/update/{seq}")
	public ResponseEntity<Void> updateBoard(@PathVariable Integer seq,@RequestPart("title") String title,@RequestPart("contents") String contents,@RequestPart("category") String category,@RequestPart(value = "files", required = false) MultipartFile[] files) throws Exception{

		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setCategory(category);

		service.updateBoard(dto);

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

	            Board_FileDTO fdto = new Board_FileDTO();
	            fdto.setOri_name(oriName);
	            fdto.setSys_name(sysName);
	            fdto.setParent_seq(seq);
	            fservice.insert(fdto);
	        }
	    }

		return ResponseEntity.ok().build();
	}

	@PutMapping("/updateDept/{seq}")
	public ResponseEntity<Void> updateDept(@PathVariable Integer seq,@RequestPart("title") String title,@RequestPart("contents") String contents,@RequestPart("category") String category,@RequestPart(value = "files", required = false) MultipartFile[] files) throws Exception{

		DeptBoardDTO dto = new DeptBoardDTO();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setCategory(category);

		service.updateDept(dto);

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

	            DeptBoard_FileDTO fdto = new DeptBoard_FileDTO();
	            fdto.setOri_name(oriName);
	            fdto.setSys_name(sysName);
	            fdto.setParent_seq(seq);
	            fservice.insertDept(fdto);
	        }
	    }

		return ResponseEntity.ok().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
