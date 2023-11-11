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
import com.kdt.dto.MemberDTO;
import com.kdt.dto.PositionDTO;
import com.kdt.services.AdminService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping()
	public ResponseEntity<String> insert(@RequestParam String name, @RequestParam String id, @RequestParam String password, @RequestParam String group_name, @RequestParam String position, @RequestParam String contact, @RequestParam String email) throws Exception {
		System.out.println(name + " : " + id + " : " + password + " : " + group_name + " : " + position + " : " + contact + " : " + email);

		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPassword(Encryption.getSHA512(password));
		dto.setGroup_name(group_name);
		dto.setPosition(position);
		dto.setContact(contact);
		dto.setEmail(email);

		dto = service.insert(dto);
		System.out.println("등록됨ㅋ");
		return ResponseEntity.ok("");
	}

	@PostMapping("/dept")
	public ResponseEntity<String> insertDept(@RequestParam String dept_name){
		System.out.println(dept_name);

		DepartmentDTO dto = new DepartmentDTO();
		dto.setDept_name(dept_name);

		dto = service.insertDept(dto);
		return ResponseEntity.ok("");
	}

	@PostMapping("/position")
	public ResponseEntity<String> insertPosition(@RequestParam String position){
		System.out.println(position);

		PositionDTO dto = new PositionDTO();
		dto.setPosition(position);

		dto = service.insertPosition(dto);
		return ResponseEntity.ok("");
	}

	@GetMapping("/user")
	public ResponseEntity<List<MemberDTO>> selectAllUser(){
		List<MemberDTO> users = service.selectAllUser();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/inactive")
	public ResponseEntity<List<MemberDTO>> selectAllInactive(){
		List<MemberDTO> inactive = service.selectAllInactive();
		return ResponseEntity.ok(inactive);
	}

	@GetMapping("/dept")
	public ResponseEntity<List<DepartmentDTO>> selectAllDept(){
		List<DepartmentDTO> dept = service.selectAllDept();
		return ResponseEntity.ok(dept);
	}

	@GetMapping("/position")
	public ResponseEntity<List<PositionDTO>> selectAllPosition(){
		List<PositionDTO> position = service.selectAllPosition();
		return ResponseEntity.ok(position);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok("");
	}

	@DeleteMapping("/deleteD/{dept_name}")
	public ResponseEntity<String> deleteDept(@PathVariable String dept_name) {
		service.deleteDept(dept_name);
		return ResponseEntity.ok("");
	}

	@DeleteMapping("/deleteP/{position}")
	public ResponseEntity<String> deletePosition(@PathVariable String position) {
		service.deletePosition(position);
		return ResponseEntity.ok("");
	}

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

	@PutMapping("/updateDept")
	public ResponseEntity<Void> update(@RequestParam String name, @RequestParam String group_name, @RequestParam String position){

		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setGroup_name(group_name);
		dto.setPosition(position);

		service.update(dto);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/updatePw/{id}")
	public ResponseEntity<Void> updatePassword(@PathVariable String id, @RequestParam String password) throws Exception{

		String Encry = Encryption.getSHA512(password);

		service.updatePassword(Encry, id);
		System.out.println("이야 비번 바뀜");

		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> errorHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
