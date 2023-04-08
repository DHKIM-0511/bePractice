package com.ssafy.noticeboard.post.dto;

import java.sql.*;
public class Posts {
	private int post_no;
	private String title;
	private Clob post_content;
	private Timestamp post_create;
	private Timestamp post_update;
	public Posts() {
		super();
	}
	public Posts(int post_no, String title, Clob post_content, Timestamp post_create, Timestamp post_update) {
		super();
		this.post_no = post_no;
		this.title = title;
		this.post_content = post_content;
		this.post_create = post_create;
		this.post_update = post_update;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Clob getPost_content() {
		return post_content;
	}
	public void setPost_content(Clob post_content) {
		this.post_content = post_content;
	}
	public Timestamp getPost_create() {
		return post_create;
	}
	public void setPost_create(Timestamp post_create) {
		this.post_create = post_create;
	}
	public Timestamp getPost_update() {
		return post_update;
	}
	public void setPost_update(Timestamp post_update) {
		this.post_update = post_update;
	}
	@Override
	public String toString() {
		return "Post [post_no=" + post_no + ", title=" + title + ", post_content=" + post_content + ", post_create="
				+ post_create + ", post_update=" + post_update + "]";
	}
}
