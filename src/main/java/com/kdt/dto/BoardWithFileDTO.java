package com.kdt.dto;

import java.sql.Timestamp;

public class BoardWithFileDTO {
	private int seq;
	private String title;
	private String writer;
	private String contents;
	private Timestamp write_date;
	private int view_count;
	private String category;
	private int fseq;
	private int parent_seq;
	private String ori_name;
	private String sys_name;
	private String name;
	private String group_name;
	private String position;
	private String profile_image;

	public BoardWithFileDTO(int seq, String title, String writer, String contents, Timestamp write_date, int view_count,
			String category, int fseq, int parent_seq, String ori_name, String sys_name, String name, String group_name,
			String position, String profile_image) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.write_date = write_date;
		this.view_count = view_count;
		this.category = category;
		this.fseq = fseq;
		this.parent_seq = parent_seq;
		this.ori_name = ori_name;
		this.sys_name = sys_name;
		this.name = name;
		this.group_name = group_name;
		this.position = position;
		this.profile_image = profile_image;
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

	public int getFseq() {
		return fseq;
	}

	public void setFseq(int fseq) {
		this.fseq = fseq;
	}

	public int getParent_seq() {
		return parent_seq;
	}

	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}

	public String getOri_name() {
		return ori_name;
	}

	public void setOri_name(String ori_name) {
		this.ori_name = ori_name;
	}

	public String getSys_name() {
		return sys_name;
	}

	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
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

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public BoardWithFileDTO() {}
}
