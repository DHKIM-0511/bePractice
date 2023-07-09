package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Review;

public interface ReviewDao {
	
	// 특정 비디오 리뷰 조회
	public List<Review> selectByVideoSeq(int videoSeq);
	
	// 리뷰 상세
	public Review selectOne(int seq);
	
	// 리뷰 등록
	public int insert(Review review);
	
	// 리뷰 수정
	public int update(Review review);

	// 리뷰 삭제
	public int delete(int seq);
}