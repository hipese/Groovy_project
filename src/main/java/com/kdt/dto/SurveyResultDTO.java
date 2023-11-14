package com.kdt.dto;

public class SurveyResultDTO {
	
	private int multi_seq;
	private String multi_res_contents;
	private int multi_count;
	
	public SurveyResultDTO() {
		super();
	}

	public SurveyResultDTO(int multi_seq, String multi_res_contents, int multi_count) {
		super();
		this.multi_seq = multi_seq;
		this.multi_res_contents = multi_res_contents;
		this.multi_count = multi_count;
	}

	public int getMulti_seq() {
		return multi_seq;
	}

	public void setMulti_seq(int multi_seq) {
		this.multi_seq = multi_seq;
	}

	public String getMulti_res_contents() {
		return multi_res_contents;
	}

	public void setMulti_res_contents(String multi_res_contents) {
		this.multi_res_contents = multi_res_contents;
	}

	public int getMulti_count() {
		return multi_count;
	}

	public void setMulti_count(int multi_count) {
		this.multi_count = multi_count;
	}
	
	

}
