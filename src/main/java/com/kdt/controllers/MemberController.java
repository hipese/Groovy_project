package com.kdt.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kdt.dto.DepartmentDTO;
import com.kdt.dto.MemberDTO;
import com.kdt.dto.SearchTermDTO;
import com.kdt.dto.Sign_MembersIDDTO;
import com.kdt.services.MemberService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	MemberService mservice;

	@Autowired
	HttpSession session;

	@GetMapping
	public ResponseEntity<MemberDTO> memberProfile() {
		String id = (String) session.getAttribute("loginID");
		MemberDTO dto = mservice.getprofile(id);
		
		return ResponseEntity.ok(dto);
	}
	

	@GetMapping("/department")
	public ResponseEntity<List> departmentAll(){
		
		 List<DepartmentDTO> dto = mservice.departmentAll();
		 return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/selectedEmployee")
	public ResponseEntity<List> selectedEmployee(){
		
		 List<SearchTermDTO> dto = mservice.selectedEmployee();
		 return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{selectedRow}")
	public ResponseEntity<SearchTermDTO> selectApprover(@PathVariable String selectedRow){
		SearchTermDTO dto = mservice.selectApprover(selectedRow);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/detail/{selectedRow}")
	public ResponseEntity<MemberDTO> selectDetail(@PathVariable String selectedRow){
		MemberDTO dto = mservice.selectDetail(selectedRow);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/search/{searchText}")
	public ResponseEntity<List> searchEmployee(@PathVariable String searchText){
		
		System.out.println("선택한놈 검색할려는 문자: "+ searchText);
		List<SearchTermDTO> dto = mservice.searchEmployee(searchText);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/signWriterInfo/{signWriterInfo}")
	public ResponseEntity<SearchTermDTO> sign_WriterInfo(@PathVariable String signWriterInfo){
	    System.out.println("작성자 아이디 : "+ signWriterInfo);
	    SearchTermDTO writerInfo = mservice.sign_WriterInfo(signWriterInfo);
	    return ResponseEntity.ok(writerInfo);
	}
	
	@GetMapping("/signReceiverInfo/{signReceiverInfo}")
	public ResponseEntity<SearchTermDTO> sign_ReceiverInfo(@PathVariable String signReceiverInfo){
	    SearchTermDTO receiverInfo = mservice.sign_ReceiverInfo(signReceiverInfo);
	    return ResponseEntity.ok(receiverInfo);
	}
	
	
	 
	
	@PutMapping("/ContactUpdate/{contact}")
	public ResponseEntity<String> updateContact(@PathVariable String contact) {
		System.out.println("전화번호변경 요청임");
	    String id = (String) session.getAttribute("loginID");
	    mservice.updateContact(id, contact); // 서비스 메소드에 id와 contact 값을 전달합니다.
	    return ResponseEntity.ok("변경 완료");
	}
	
	@PutMapping("/emailUpdate/{email}")
	public ResponseEntity<String> updateEmail(@PathVariable String email) {
	    String id = (String) session.getAttribute("loginID");
	    mservice.updateEmail(id, email); // 서비스 메소드에 id와 contact 값을 전달합니다.
	    return ResponseEntity.ok("변경 완료");
	}

	@PostMapping
	public ResponseEntity<String> updateImage(@RequestParam("cfile") MultipartFile cfile) throws Exception {
		String fileName = StringUtils.cleanPath(cfile.getOriginalFilename());
		String id = (String) session.getAttribute("loginID");
		
		mservice.updateImage(id, fileName);
		
		File uploadPath=new File("c:/profiles");
		
		if(!uploadPath.exists()) {
			uploadPath.mkdir();
		}
		
		Path storageLocation = Paths.get("C:\\profiles");
		
		try {
			if (cfile.isEmpty()) {
				throw new Exception("Failed to store empty file " + fileName);
			}
			// 파일의 경로를 생성합니다.
			Path destinationFile = storageLocation.resolve(Paths.get(fileName)).normalize().toAbsolutePath();
			// 파일을 저장합니다.
			Files.copy(cfile.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
			return ResponseEntity.ok(fileName);
		} catch (IOException e) {
			throw new Exception("Failed to store file " + fileName, e);
		}
		
	}

}
