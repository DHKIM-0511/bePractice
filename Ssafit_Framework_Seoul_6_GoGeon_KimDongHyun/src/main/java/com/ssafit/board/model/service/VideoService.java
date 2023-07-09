package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Video;

public interface VideoService {
	
	// 비디오 정보 전체 조회
	public List<Video> getVideoList();
	
	// 특정 비디오 정보 조회
	public Video getVideo(int seq);
	
	// 비디오 추가
	public int addVideo(Video video);
	
	// 비디오 수정
	public int modifyVideo(Video video);
	
	// 비디오 삭제
	public int removeVideo(int seq);
}