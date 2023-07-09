package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Review;

public interface ReviewService {
	
	// 특정 비디오 리뷰 목록 조회
	public List<Review> getReviewList(int videoSeq);
	
	// 리뷰 등록
	public int regist(Review review);
	
	// 리뷰 수정
	public int modify(Review review);
	
	// 리뷰 상세
	public Review getReview(int seq);
	
	// 리뷰 삭제
	public int remove(int seq);
}