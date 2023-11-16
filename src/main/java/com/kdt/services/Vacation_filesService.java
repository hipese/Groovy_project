package com.kdt.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.Vacation_filesDAO;
import com.kdt.dto.Vacation_filesDTO;

@Service
public class Vacation_filesService {
	@Autowired
	private Vacation_filesDAO vdao;

	public int insert(Vacation_filesDTO dto) {
		return vdao.insert(dto);
	}

	public List<Vacation_filesDTO> selectBySeq(int parent_seq) {
		return vdao.selectBySeq(parent_seq);
	}
}
