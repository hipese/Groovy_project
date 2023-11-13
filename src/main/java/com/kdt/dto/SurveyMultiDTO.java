package com.kdt.dto;

public class SurveyMultiDTO {

	private int multi_seq;
	private int surseq;
	private String multi_answer_0;
	private String multi_answer_1;
	private String multi_answer_2;
	private String multi_answer_3;
	private String multi_answer_4;
	public SurveyMultiDTO() {
		super();
	}
	public SurveyMultiDTO(int multi_seq, int surseq, String multi_answer_0, String multi_answer_1,
			String multi_answer_2, String multi_answer_3, String multi_answer_4) {
		super();
		this.multi_seq = multi_seq;
		this.surseq = surseq;
		this.multi_answer_0 = multi_answer_0;
		this.multi_answer_1 = multi_answer_1;
		this.multi_answer_2 = multi_answer_2;
		this.multi_answer_3 = multi_answer_3;
		this.multi_answer_4 = multi_answer_4;
	}
	public int getMulti_seq() {
		return multi_seq;
	}
	public void setMulti_seq(int multi_seq) {
		this.multi_seq = multi_seq;
	}
	public int getSurseq() {
		return surseq;
	}
	public void setSurseq(int surseq) {
		this.surseq = surseq;
	}
	public String getMulti_answer_0() {
		return multi_answer_0;
	}
	public void setMulti_answer_0(String multi_answer_0) {
		this.multi_answer_0 = multi_answer_0;
	}
	public String getMulti_answer_1() {
		return multi_answer_1;
	}
	public void setMulti_answer_1(String multi_answer_1) {
		this.multi_answer_1 = multi_answer_1;
	}
	public String getMulti_answer_2() {
		return multi_answer_2;
	}
	public void setMulti_answer_2(String multi_answer_2) {
		this.multi_answer_2 = multi_answer_2;
	}
	public String getMulti_answer_3() {
		return multi_answer_3;
	}
	public void setMulti_answer_3(String multi_answer_3) {
		this.multi_answer_3 = multi_answer_3;
	}
	public String getMulti_answer_4() {
		return multi_answer_4;
	}
	public void setMulti_answer_4(String multi_answer_4) {
		this.multi_answer_4 = multi_answer_4;
	}
	
	
}
