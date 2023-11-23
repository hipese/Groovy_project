package com.kdt.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.Board_FileDTO;
import com.kdt.dto.DeptBoard_FileDTO;
import com.kdt.services.Board_FileService;

@RestController
@RequestMapping("/api/boardFile")
public class Board_FileController {
	@Autowired
	Board_FileService fservice;

	@GetMapping("/{parent_seq}")
	public ResponseEntity<List<Board_FileDTO>> selectBySeq(@PathVariable Integer parent_seq) {
		List<Board_FileDTO> files = fservice.selectBySeq(parent_seq);
		return ResponseEntity.ok(files);
	}

	@GetMapping("/dept/{parent_seq}")
	public ResponseEntity<List<DeptBoard_FileDTO>> selectDeptBySeq(@PathVariable Integer parent_seq) {
		List<DeptBoard_FileDTO> files = fservice.selectDeptBySeq(parent_seq);
		return ResponseEntity.ok(files);
	}   

	@GetMapping("/download/{sys_name}")
	public ResponseEntity<Resource> download(@PathVariable String sys_name) {
		String filePath = "/home/ubuntu/uploads" + sys_name;

		byte[] fileContent;
		try (InputStream inputStream = new FileInputStream(new File(filePath))) {
			fileContent = inputStream.readAllBytes();
		} catch (IOException e) {
			return ResponseEntity.notFound().build();
		}

		ByteArrayResource resource = new ByteArrayResource(fileContent);

		return ResponseEntity.ok()
				.contentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(fileContent.length)
				.body(resource);

	}

	@GetMapping("/deptDownload/{sys_name}")
	public ResponseEntity<Resource> Deptdownload(@PathVariable String sys_name) {
		String filePath = "/home/ubuntu/uploads/" + sys_name;

		byte[] fileContent;
		try (InputStream inputStream = new FileInputStream(new File(filePath))) {
			fileContent = inputStream.readAllBytes();
		} catch (IOException e) {
			return ResponseEntity.notFound().build();
		}

		ByteArrayResource resource = new ByteArrayResource(fileContent);

		return ResponseEntity.ok()
				.contentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(fileContent.length)
				.body(resource);

	}

}
