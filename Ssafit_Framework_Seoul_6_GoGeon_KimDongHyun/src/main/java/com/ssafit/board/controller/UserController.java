package com.ssafit.board.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ssafit.board.model.dto.User;
import com.ssafit.board.model.service.UserService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api-user")
@Api(tags = "사용자 컨트롤러")
public class UserController {
	
	@Autowired
	private UserService service;

	// 회원 정보 전체 조회
	@GetMapping("/list")
	public ResponseEntity<List<User>> getList() {
		List<User> users = service.getUserList();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Void> login(User user, HttpSession session, Model model) {
		User loginUser = service.getUser(user.getId());
		if (loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
			session.setAttribute("loginUser", loginUser);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			model.addAttribute("msg", "로그인에 실패했습니다.");
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 회원가입
	@PostMapping("/join")
	public ResponseEntity<?> join(User user) {
		int result = service.listUser(user);
		if (result == 0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		}
	}
	
	// 개별 회원 정보 조회
	@GetMapping("/info/{id}")
	public ResponseEntity<User> getInfo(@PathVariable String id) {
		User user = service.getUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// 회원 정보 수정
	@PutMapping("/info")
	public ResponseEntity<?> updateInfo(User user) {
		int result = service.modifyUser(user);
		if (result == 0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
	}
	
	// 회원탈퇴
	@DeleteMapping("/join")
	public ResponseEntity<?> leave(String id) {
		int result = service.delistUser(id);
		if (result == 0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
	}
}