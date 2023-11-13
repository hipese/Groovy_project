package com.kdt.dto;

public class SurveyShortDTO {

	private int short_seq;
	private int surseq;
	private String short_contents;
	public SurveyShortDTO() {
		super();
	}
	public SurveyShortDTO(int short_seq, int surseq, String short_contents) {
		super();
		this.short_seq = short_seq;
		this.surseq = surseq;
		this.short_contents = short_contents;
	}
	public int getShort_seq() {
		return short_seq;
	}
	public void setShort_seq(int short_seq) {
		this.short_seq = short_seq;
	}
	public int getSurseq() {
		return surseq;
	}
	public void setSurseq(int surseq) {
		this.surseq = surseq;
	}
	public String getShort_contents() {
		return short_contents;
	}
	public void setShort_contents(String short_contents) {
		this.short_contents = short_contents;
	}
	
	
}
