package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.User;

public interface UserService {
	
	// 회원 정보 전체 조회
	public List<User> getUserList();
	
	// 특정 회원 정보 조회
	public User getUser(String id);
	
	// 회원 가입
	public int listUser(User user);
	
	// 회원 정보 수정
	public int modifyUser(User user);
	
	// 회원 탈퇴
	public int delistUser(String id);
}