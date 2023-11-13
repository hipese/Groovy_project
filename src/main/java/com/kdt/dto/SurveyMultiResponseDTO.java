package com.kdt.dto;

public class SurveyMultiResponseDTO {
	private int multi_res_seq;
	private int surseq;
	private int multi_seq;
	private String multi_res_contents;
	private String multi_res_writer;
	public SurveyMultiResponseDTO() {
		super();
	}
	public SurveyMultiResponseDTO(int multi_res_seq, int surseq, int multi_seq, String multi_res_contents,
			String multi_res_writer) {
		super();
		this.multi_res_seq = multi_res_seq;
		this.surseq = surseq;
		this.multi_seq = multi_seq;
		this.multi_res_contents = multi_res_contents;
		this.multi_res_writer = multi_res_writer;
	}
	public int getMulti_res_seq() {
		return multi_res_seq;
	}
	public void setMulti_res_seq(int multi_res_seq) {
		this.multi_res_seq = multi_res_seq;
	}
	public int getSurseq() {
		return surseq;
	}
	public void setSurseq(int surseq) {
		this.surseq = surseq;
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
	public String getMulti_res_writer() {
		return multi_res_writer;
	}
	public void setMulti_res_writer(String multi_res_writer) {
		this.multi_res_writer = multi_res_writer;
	}
	
}

