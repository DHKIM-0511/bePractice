package com.ssafy.noticeboard.comment.dto;

import java.sql.Clob;

public class Comments {
	private int comment_no;
	private Clob comment_content;
	private int comment_create;
	private int comment_update;
	public Comments() {
		super();
	}
	public Comments(int comment_no, Clob comment_content, int comment_create, int comment_update) {
		super();
		this.comment_no = comment_no;
		this.comment_content = comment_content;
		this.comment_create = comment_create;
		this.comment_update = comment_update;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public Clob getComment_content() {
		return comment_content;
	}
	public void setComment_content(Clob comment_content) {
		this.comment_content = comment_content;
	}
	public int getComment_create() {
		return comment_create;
	}
	public void setComment_create(int comment_create) {
		this.comment_create = comment_create;
	}
	public int getComment_update() {
		return comment_update;
	}
	public void setComment_update(int comment_update) {
		this.comment_update = comment_update;
	}
	@Override
	public String toString() {
		return "Comments [comment_no=" + comment_no + ", comment_content=" + comment_content + ", comment_create="
				+ comment_create + ", comment_update=" + comment_update + "]";
	}
	
}
