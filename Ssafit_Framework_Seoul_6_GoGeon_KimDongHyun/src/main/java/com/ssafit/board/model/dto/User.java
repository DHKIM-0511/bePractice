package com.ssafit.board.model.dto;

public class User {
	private int seq;
	private String id;
	private String password;
	private String profile;
	private String email;
	private String name;
	private String nickname;
	private String birth_date;
	private String category;
	private String gender;
	private String created_at;
	private String status;
	
	public User() {}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "User [seq=" + seq + ", id=" + id + ", password=" + password + ", nickname=" + nickname + ", email="
				+ email + ", regDate=" + regDate + ", lastLogin=" + lastLogin + "]";
	}
}