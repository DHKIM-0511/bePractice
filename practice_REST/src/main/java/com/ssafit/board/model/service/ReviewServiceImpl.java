package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.ReviewDao;
import com.ssafit.board.model.dto.Review;
@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao dao;
	
	@Override
	public List<Review> getReviewList(int videoSeq) {
		return dao.selectByVideoSeq(videoSeq);
	}

	@Override
	public int regist(Review review) {
		return dao.insert(review);
	}

	@Override
	public int modify(Review review) {
		return dao.update(review);
	}

	@Override
	public Review getReview(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int remove(int seq) {
		return dao.delete(seq);
	}
}
