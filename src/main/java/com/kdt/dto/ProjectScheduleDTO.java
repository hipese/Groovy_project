package com.kdt.dto;

import java.sql.Timestamp;

public class ProjectScheduleDTO {
	
	private int pschedule_seq;
	private int pseq;
	private Timestamp pschedule_start;
	private Timestamp pschedule_end;
	private String pschedule_contents;
	private String pschedule_importance;
	private int pschedule_state;
	public ProjectScheduleDTO() {
		super();
	}
	public ProjectScheduleDTO(int pschedule_seq, int pseq, Timestamp pschedule_start, Timestamp pschedule_end,
			String pschedule_contents, String pschedule_importance, int pschedule_state) {
		super();
		this.pschedule_seq = pschedule_seq;
		this.pseq = pseq;
		this.pschedule_start = pschedule_start;
		this.pschedule_end = pschedule_end;
		this.pschedule_contents = pschedule_contents;
		this.pschedule_importance = pschedule_importance;
		this.pschedule_state = pschedule_state;
	}
	public int getPschedule_seq() {
		return pschedule_seq;
	}
	public void setPschedule_seq(int pschedule_seq) {
		this.pschedule_seq = pschedule_seq;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public Timestamp getPschedule_start() {
		return pschedule_start;
	}
	public void setPschedule_start(Timestamp pschedule_start) {
		this.pschedule_start = pschedule_start;
	}
	public Timestamp getPschedule_end() {
		return pschedule_end;
	}
	public void setPschedule_end(Timestamp pschedule_end) {
		this.pschedule_end = pschedule_end;
	}
	public String getPschedule_contents() {
		return pschedule_contents;
	}
	public void setPschedule_contents(String pschedule_contents) {
		this.pschedule_contents = pschedule_contents;
	}
	public String getPschedule_importance() {
		return pschedule_importance;
	}
	public void setPschedule_importance(String pschedule_importance) {
		this.pschedule_importance = pschedule_importance;
	}
	public int getPschedule_state() {
		return pschedule_state;
	}
	public void setPschedule_state(int pschedule_state) {
		this.pschedule_state = pschedule_state;
	}
	
	

}
