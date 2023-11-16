package com.kdt.dto;

import java.sql.Timestamp;

public class DBoardWithMemberDTO {
	private int seq;
	private String title;
	private String writer;
	private String contents;
	private Timestamp write_date;
	private int view_count;
	private String category;
	private String dept;
	private int fseq;
	private String name;
	private String group_name;
	private String position;
	
	public DBoardWithMemberDTO(int seq, String title, String writer, String contents, Timestamp write_date,
			int view_count, String category, String dept, int fseq, String name, String group_name, String position) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.write_date = write_date;
		this.view_count = view_count;
		this.category = category;
		this.dept = dept;
		this.fseq = fseq;
		this.name = name;
		this.group_name = group_name;
		this.position = position;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getFseq() {
		return fseq;
	}
	public void setFseq(int fseq) {
		this.fseq = fseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public DBoardWithMemberDTO() {}
}
