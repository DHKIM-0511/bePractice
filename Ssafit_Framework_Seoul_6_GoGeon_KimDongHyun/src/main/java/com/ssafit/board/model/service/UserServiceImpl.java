package com.ssafit.board.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ssafit.board.model.dao.UserDao;
import com.ssafit.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public List<User> getUserList() {
		return dao.selectAll();
	}

	@Override
	public User getUser(String id) {
		return dao.selectOne(id);
	}

	@Override
	@Transactional
	public int listUser(User user) {
		return dao.insert(user);
	}

	@Override
	@Transactional
	public int modifyUser(User user) {
		return dao.update(user);
	}

	@Override
	@Transactional
	public int delistUser(String id) {
		return dao.delete(id);
	}
}