package com.kdt.dto;

public class SurveyShortResponseDTO {

	private int short_res_seq;
	private int surseq;
	private int short_seq;
	private String short_res_contents;
	private String short_res_writer;
	public SurveyShortResponseDTO() {
		super();
	}
	public SurveyShortResponseDTO(int short_res_seq, int surseq, int short_seq, String short_res_contents,
			String short_res_writer) {
		super();
		this.short_res_seq = short_res_seq;
		this.surseq = surseq;
		this.short_seq = short_seq;
		this.short_res_contents = short_res_contents;
		this.short_res_writer = short_res_writer;
	}
	public int getShort_res_seq() {
		return short_res_seq;
	}
	public void setShort_res_seq(int short_res_seq) {
		this.short_res_seq = short_res_seq;
	}
	public int getSurseq() {
		return surseq;
	}
	public void setSurseq(int surseq) {
		this.surseq = surseq;
	}
	public int getShort_seq() {
		return short_seq;
	}
	public void setShort_seq(int short_seq) {
		this.short_seq = short_seq;
	}
	public String getShort_res_contents() {
		return short_res_contents;
	}
	public void setShort_res_contents(String short_res_contents) {
		this.short_res_contents = short_res_contents;
	}
	public String getShort_res_writer() {
		return short_res_writer;
	}
	public void setShort_res_writer(String short_res_writer) {
		this.short_res_writer = short_res_writer;
	}
}
