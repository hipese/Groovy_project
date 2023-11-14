package com.kdt.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdt.dto.ProjectProgressDTO;
import com.kdt.dto.SurveyDTO;
import com.kdt.dto.SurveyMultiDTO;
import com.kdt.dto.SurveyMultiResponseDTO;
import com.kdt.dto.SurveyResultDTO;
import com.kdt.dto.SurveyShortDTO;
import com.kdt.dto.SurveyShortResponseDTO;
import com.kdt.services.SurveyService;

@RestController
@RequestMapping("/api/survey")
public class SurveyConrtoller {
	
	@Autowired
	private SurveyService SService;
	
	@PostMapping
	public ResponseEntity<String> insertSurvey(@RequestBody List<HashMap<String, Object>> param){
		
		SurveyShortDTO sdto = new SurveyShortDTO();
		SurveyMultiDTO mdto = new SurveyMultiDTO();
		int result = 0;
		for(HashMap<String,Object> data : param) {
			
			if(data.containsKey("surtitle")) {
				SurveyDTO dto = new SurveyDTO();
				dto.setSurtitle(data.get("surtitle").toString());
				dto.setSurcontents(data.get("surcontents").toString());
				dto.setSurwriter(data.get("surwriter").toString());
				result = SService.insertSurvey(dto);
			}
			if(data.containsKey("type")){
				if("short".equals(data.get("type"))) {
					sdto.setSurseq(result);
					sdto.setShort_contents(data.get("questions").toString());
					SService.insertShort(sdto);
				}
				
				if("multi".equals(data.get("type"))) {
					mdto.setSurseq(result);
					List<Object> questions = (List<Object>) data.get("questions");
					for(int i=0; i < questions.size(); i++) {
						switch (i) {
					        case 0:
					            mdto.setMulti_answer_0(questions.get(i).toString());
					            break;
					        case 1:
					        	mdto.setMulti_answer_1(questions.get(i).toString());
					            break;
					        case 2:
					        	mdto.setMulti_answer_2(questions.get(i).toString());
					            break;
					        case 3:
					        	mdto.setMulti_answer_3(questions.get(i).toString());
					            break;
					        case 4:
					        	mdto.setMulti_answer_4(questions.get(i).toString());
					            break;
						}
					}
					SService.insertMulti(mdto);
				}
			}
			
		}
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/content/{seq}")
	public ResponseEntity<List<HashMap<String, Object>>> selectContent(@PathVariable int seq){
		
		SurveyDTO dto = SService.selectSurvey(seq);
		List<SurveyShortDTO> short_list = SService.selectShort(seq);
		List<SurveyMultiDTO> multi_list = SService.selectMulti(seq);
		List<HashMap<String, Object>> parseData = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String, Object> common_data = new HashMap<String, Object>();
		
		
		
		common_data.put("title", dto.getSurtitle());
		common_data.put("contents", dto.getSurcontents());
		common_data.put("writer", dto.getSurwriter());
		common_data.put("write_date",dto.getSurwrite_date());
		
		parseData.add(common_data);
		
		for(SurveyShortDTO data : short_list) {
			HashMap<String, Object> short_data = new HashMap<String, Object>();
			short_data.put("type", "short");
			short_data.put("short_seq", data.getShort_seq());
			short_data.put("questions", data.getShort_contents());
			parseData.add(short_data);
		}
		
		for(SurveyMultiDTO data : multi_list) {
			HashMap<String, Object> multi_data = new HashMap<String, Object>();
			List<Object> question_data = new ArrayList<Object>();
			multi_data.put("type", "multi");
			multi_data.put("multi_seq", data.getMulti_seq());
			
			if(data.getMulti_answer_0() != null) {
				question_data.add(data.getMulti_answer_0());
			}
			if(data.getMulti_answer_1() != null) {
				question_data.add(data.getMulti_answer_1());
			}
			if(data.getMulti_answer_2() != null) {
				question_data.add(data.getMulti_answer_2());
			}
			if(data.getMulti_answer_3() != null) {
				question_data.add(data.getMulti_answer_3());
			}
			if(data.getMulti_answer_4() != null) {
				question_data.add(data.getMulti_answer_4());
			}
			multi_data.put("questions", question_data);
			parseData.add(multi_data);					
		}
		
		return ResponseEntity.ok(parseData);
	}
	
	@PostMapping("/response/{seq}")
	public ResponseEntity<String> insertResponse(@PathVariable int seq,@RequestBody List<HashMap<String, Object>> param){
		SurveyShortResponseDTO srdto = new SurveyShortResponseDTO();
		SurveyMultiResponseDTO mrdto = new SurveyMultiResponseDTO();
		
		for(HashMap<String,Object> data : param) {			
			
			if(data.containsKey("type")){
				if("short".equals(data.get("type"))) {
					srdto.setSurseq(seq);
					srdto.setShort_seq((int)data.get("question"));
					srdto.setShort_res_contents(data.get("answer").toString());
					srdto.setShort_res_writer(data.get("writer").toString());
					SService.insertShortRes(srdto);
				}
				
				if("multi".equals(data.get("type"))) {
					mrdto.setSurseq(seq);
					mrdto.setMulti_seq((int)data.get("question"));
					mrdto.setMulti_res_contents(data.get("answer").toString());
					mrdto.setMulti_res_writer(data.get("writer").toString());
					SService.insertMultiRes(mrdto);
				}
			}
		}
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<SurveyDTO>> selectList(){
		
		List<SurveyDTO> list = SService.selectList();		
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/result/{seq}")
	public ResponseEntity<List<SurveyResultDTO>> getResult(@PathVariable int seq){
		List<SurveyResultDTO> list = SService.selectMultiResult(seq);
		
		return ResponseEntity.ok(list);
	}

}

