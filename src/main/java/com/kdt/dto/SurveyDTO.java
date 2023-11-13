package com.kdt.dto;

import java.sql.Timestamp;

public class SurveyDTO {
	
	private int surseq;
	private String surtitle;
	private String surwriter;
	private String surcontents;
	private Timestamp surwrite_date;
	private int surstate;
	public SurveyDTO() {
		super();
	}
	public SurveyDTO(int surseq, String surtitle, String surwriter, String surcontents, Timestamp surwrite_date,
			int surstate) {
		super();
		this.surseq = surseq;
		this.surtitle = surtitle;
		this.surwriter = surwriter;
		this.surcontents = surcontents;
		this.surwrite_date = surwrite_date;
		this.surstate = surstate;
	}
	public int getSurseq() {
		return surseq;
	}
	public void setSurseq(int surseq) {
		this.surseq = surseq;
	}
	public String getSurtitle() {
		return surtitle;
	}
	public void setSurtitle(String surtitle) {
		this.surtitle = surtitle;
	}
	public String getSurwriter() {
		return surwriter;
	}
	public void setSurwriter(String surwriter) {
		this.surwriter = surwriter;
	}
	public String getSurcontents() {
		return surcontents;
	}
	public void setSurcontents(String surcontents) {
		this.surcontents = surcontents;
	}
	public Timestamp getSurwrite_date() {
		return surwrite_date;
	}
	public void setSurwrite_date(Timestamp surwrite_date) {
		this.surwrite_date = surwrite_date;
	}
	public int getSurstate() {
		return surstate;
	}
	public void setSurstate(int surstate) {
		this.surstate = surstate;
	}

}
