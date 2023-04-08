package com.ssafy.noticeboard.user.dto;

import java.sql.Timestamp;

public class Users {
	private int user_no;
	private String user_id;
	private String user_pw;
	private String user_email;
	private String user_name;
	private String user_gender;
	private Timestamp user_create;
	
	public Users() {
	}
	public Users(int user_no, String user_id, String user_pw, String user_email, String user_name, String user_gender,
			Timestamp user_create) {
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_email = user_email;
		this.user_name = user_name;
		this.user_gender = user_gender;
		this.user_create = user_create;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public Timestamp getUser_create() {
		return user_create;
	}
	public void setUser_create(Timestamp user_create) {
		this.user_create = user_create;
	}
	
	@Override
	public String toString() {
		return "User [user_no=" + user_no + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_email="
				+ user_email + ", user_name=" + user_name + ", user_gender=" + user_gender + ", user_create="
				+ user_create + "]";
	}
}
