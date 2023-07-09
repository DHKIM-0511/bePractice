package com.ssafit.board.model.dto;

public class Review {
	private int seq;
	private String title;
	private String content;
	private String regDate;
	private String modDate;
	private int userSeq;
	private int videoSeq;
	
	
	public Review() {
		// TODO Auto-generated constructor stub
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getVideoSeq() {
		return videoSeq;
	}

	public void setVideoSeq(int videoSeq) {
		this.videoSeq = videoSeq;
	}

	@Override
	public String toString() {
		return "Review [seq=" + seq + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", modDate=" + modDate + "]";
	}
}
