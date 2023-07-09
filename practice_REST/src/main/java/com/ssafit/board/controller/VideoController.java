package com.ssafit.board.controller;

import java.util.List;
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
import com.ssafit.board.model.dto.Video;
import com.ssafit.board.model.service.ReviewService;
import com.ssafit.board.model.service.VideoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api-video")
@Api(tags = "비디오 컨트롤러")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private ReviewService reviewService;
	
	// 비디오 전체 조회
	@GetMapping("/list")
	public ResponseEntity<List<Video>> getList() {
		List<Video> videos = videoService.getVideoList();
		return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
	}
	
	// 비디오 상세 조회
	@GetMapping("/list/{seq}")
	public ResponseEntity<Video> detail(@PathVariable int seq) {
		Video video = videoService.getVideo(seq);
		List<Review> reviews = reviewService.getReviewList(seq);
		video.setReviews(reviews);
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
	
	// 비디오 추가
	@PostMapping("/list")
	public ResponseEntity<?> add(Video video) {
		int result = videoService.addVideo(video);
		if (result == 0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		}
	}
	
	// 비디오 수정
	@PutMapping("/list")
	public ResponseEntity<?> modify(Video video) {
		int result = videoService.modifyVideo(video);
		if (result == 0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
	}
	
	// 비디오 제거
	@DeleteMapping("/list/{seq}")
	public ResponseEntity<?> remove(@PathVariable int seq) {
		int result = videoService.removeVideo(seq);
		if (result == 0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
	}
}