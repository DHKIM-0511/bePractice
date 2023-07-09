package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.User;

public interface UserDao {

	// 회원정보 전체 조회
	public List<User> selectAll();
	
	// 특정 회원 정보 조회
	public User selectOne(String id);
	
	// 회원 정보 추가
	public int insert(User user);
	
	// 회원 정보 수정
	public int update(User user);
	
	// 회원 정보 삭제
	public int delete(String id);
}