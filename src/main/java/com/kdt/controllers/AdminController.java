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

import com.kdt.commons.Encryption;
import com.kdt.dto.DepartmentDTO;
import com.kdt.dto.ExternalContactDTO;
import com.kdt.dto.MemberDTO;
import com.kdt.dto.PositionDTO;
import com.kdt.services.AdminService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	
	// 사용자 추가
	@PostMapping()
	public ResponseEntity<String> insert(@RequestParam String name, @RequestParam String id, @RequestParam String password, @RequestParam String group_name, @RequestParam String position, @RequestParam String contact, @RequestParam String email) throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPassword(Encryption.getSHA512(password));
		dto.setGroup_name(group_name);
		dto.setPosition(position);
		dto.setContact(contact);
		dto.setEmail(email);

		dto = service.insert(dto);
		return ResponseEntity.ok("");
	}

	// 부서 추가
	@PostMapping("/dept")
	public ResponseEntity<String> insertDept(@RequestParam String dept_name){
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDept_name(dept_name);

		dto = service.insertDept(dto);
		return ResponseEntity.ok("");
	}

	// 직급 추가
	@PostMapping("/position")
	public ResponseEntity<String> insertPosition(@RequestParam String position){
		PositionDTO dto = new PositionDTO();
		dto.setPosition(position);

		dto = service.insertPosition(dto);
		return ResponseEntity.ok("");
	}

	// 외부 주소록 추가
	@PostMapping("/excontact")
	public ResponseEntity<String> insertContact(@RequestParam String company, @RequestParam String group_name, @RequestParam String name, @RequestParam String position, @RequestParam String contact, @RequestParam String email){
		ExternalContactDTO dto = new ExternalContactDTO();
		dto.setCompany(company);
		dto.setGroup_name(group_name);
		dto.setName(name);
		dto.setPosition(position);
		dto.setContact(contact);
		dto.setEmail(email);

		dto = service.insertContact(dto);
		return ResponseEntity.ok("");
	}

	// 사용자 수 불러오기
	@GetMapping("/countUser")
	public ResponseEntity<Integer> countMember(){
		int users = service.countMember();
		return ResponseEntity.ok(users);
	}

	// 비활성 사용자 수 불러오기
	@GetMapping("/countInactive")
	public ResponseEntity<Integer> countInactive(){
		int inactive = service.countInactive();
		return ResponseEntity.ok(inactive);
	}

	// 사용자 정보 불러오기
	@GetMapping("/user")
	public ResponseEntity<List<MemberDTO>> selectAllUser(){
		List<MemberDTO> users = service.selectAllUser();
		return ResponseEntity.ok(users);
	}

	// 비활성 사용자 정보 불러오기
	@GetMapping("/inactive")
	public ResponseEntity<List<MemberDTO>> selectAllInactive(){
		List<MemberDTO> inactive = service.selectAllInactive();
		return ResponseEntity.ok(inactive);
	}

	// 부서 정보 불러오기
	@GetMapping("/dept")
	public ResponseEntity<List<DepartmentDTO>> selectAllDept(){
		List<DepartmentDTO> dept = service.selectAllDept();
		return ResponseEntity.ok(dept);
	}

	// 직급 정보 불러오기
	@GetMapping("/position")
	public ResponseEntity<List<PositionDTO>> selectAllPosition(){
		List<PositionDTO> position = service.selectAllPosition();
		return ResponseEntity.ok(position);
	}

	// 사용자 삭제
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok("");
	}

	// 부서 삭제
	@DeleteMapping("/deleteD/{dept_name}")
	public ResponseEntity<String> deleteDept(@PathVariable String dept_name) {
		service.deleteDept(dept_name);
		return ResponseEntity.ok("");
	}

	// 직급 삭제
	@DeleteMapping("/deleteP/{position}")
	public ResponseEntity<String> deletePosition(@PathVariable String position) {
		service.deletePosition(position);
		return ResponseEntity.ok("");
	}

	// 외부 주소록 삭제
	@DeleteMapping("/delete/contact/{seq}")
	public ResponseEntity<String> deletePosition(@PathVariable int seq) {
		service.deleteContact(seq);
		return ResponseEntity.ok("");
	}

	// 사용자 정보 수정
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestParam String name, @RequestParam String group_name, @RequestParam String position){
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setGroup_name(group_name);
		dto.setPosition(position);

		service.update(dto);

		return ResponseEntity.ok().build();
	}

	// 비밀번호 수정
	@PutMapping("/updatePw/{id}")
	public ResponseEntity<Void> updatePassword(@PathVariable String id, @RequestParam String password) throws Exception{

		String Encry = Encryption.getSHA512(password);

		service.updatePassword(Encry, id);

		return ResponseEntity.ok().build();
	}

	// 사용자 비활성화
	@PutMapping("/updateDept/{id}")
	public ResponseEntity<Void> updateInactive(@PathVariable String id){

		service.updateInactive(id);

		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
