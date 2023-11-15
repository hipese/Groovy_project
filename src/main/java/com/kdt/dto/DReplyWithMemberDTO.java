package com.kdt.dto;

import java.sql.Timestamp;

public class DReplyWithMemberDTO {

	private int seq;
	private int parent_seq;
	private String writer;
	private String contents;
	private Timestamp write_date;
	private String name;
	private String profile_image;
	private String position;

	public DReplyWithMemberDTO(int seq, int parent_seq, String writer, String contents, Timestamp write_date,
			String name, String profile_image, String position) {
		super();
		this.seq = seq;
		this.parent_seq = parent_seq;
		this.writer = writer;
		this.contents = contents;
		this.write_date = write_date;
		this.name = name;
		this.profile_image = profile_image;
		this.position=position;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	} 
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	} 

	public DReplyWithMemberDTO() {}

}
