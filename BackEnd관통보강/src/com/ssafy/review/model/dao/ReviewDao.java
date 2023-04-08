package com.ssafy.review.model.dao;

import java.util.List;

import com.ssafy.review.model.dto.Review;

public interface ReviewDao {
	//전체 리뷰 목록
	public List<Review> selectAll();
	
	//운동 리뷰 정보 등록
	public void insertReview(Review review);
	//운동 리뷰 상세 정보
	public Review selectReview(int reviewId); 
	//운동 리뷰 정보 수정 페이지 열기
	public Review updateReivew(int reviewId);
	//운동 리뷰 정보 수정
	public void update(Review review);
	//운동 리뷰 정보 삭제
	public void deleteReview(int reviewId);
	//조회수 증가
	public void updateReviewCnt(int reviewId);
	//로그인 
	public int login(String userId, String userPw);
}
