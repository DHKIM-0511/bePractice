package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.VideoDao;
import com.ssafit.board.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoDao dao;
	
	@Override
	public List<Video> getVideoList() {
		return dao.selectAll();
	}

	@Override
	public Video getVideo(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	@Transactional
	public int addVideo(Video video) {
		return dao.insert(video);
	}

	@Override
	@Transactional
	public int modifyVideo(Video video) {
		return dao.update(video);
	}

	@Override
	@Transactional
	public int removeVideo(int seq) {
		return dao.delete(seq);
	}
}