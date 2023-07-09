package com.ssafit.board.model.dto;

import java.util.List;

public class Video {
	private int seq;
	private String title;
	private String category;
	private String channelName;
	private long viewCnt;
	private String id;
	private String img;
	private List<Review> reviews;
	
	public Video() {}

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public long getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(long viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Video [seq=" + seq + ", title=" + title + ", category=" + category + ", channelName=" + channelName
				+ ", viewCnt=" + viewCnt + ", id=" + id + ", img=" + img + ", reviews=" + reviews + "]";
	}
}