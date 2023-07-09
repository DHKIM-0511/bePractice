package com.ssafit.board.model.dao;

import java.util.List;
import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;

public interface VideoDao {
	
	// 비디오 정보 전체 조회
	public List<Video> selectAll();
	
	// 특정 비디오 정보 조회
	public Video selectOne(int seq);
	
	// 비디오 조건별 검색
	public List<Video> selectByCondition(SearchCondition condition);
	
	// 비디오 정보 추가
	public int insert(Video video);
	
	// 비디오 정보 수정
	public int update(Video video);
	
	// 비디오 정보 삭제
	public int delete(int seq);
}