package com.ssafit.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.service.ReviewService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api-review")
@Api(tags = "리뷰 컨트롤러")
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	// 리뷰 상세
	@GetMapping("/list/{seq}")
	public ResponseEntity<Review> getReview(@PathVariable int seq){
		Review review = service.getReview(seq);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
	
	// 리뷰 등록
	@PostMapping("/list")
	public ResponseEntity<?> registReview(Review review){
		int result = service.regist(review);
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		else return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	// 리뷰 수정
	@PutMapping("/list")
	public ResponseEntity<?> updateReview(Review review){
		int result = service.modify(review);
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		else return new ResponseEntity<Integer>(result , HttpStatus.OK);
	}
	
	// 리뷰 삭제
	@DeleteMapping("/list/{seq}")
	public ResponseEntity<?> deleteReview(@PathVariable int seq){
		int result = service.remove(seq);
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		else return new ResponseEntity<Integer>(result , HttpStatus.OK); 
	}
}