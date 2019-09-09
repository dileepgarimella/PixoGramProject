package com.sba.pixogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pixogram.entity.Follow;
import com.sba.pixogram.repository.FollowRepository;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowRepository followRepo;

	@Override
	public Follow follow(Follow follow) {
		return followRepo.save(follow);
	}

	@Override
	public List<Follow> getAll() {
		return (List<Follow>) followRepo.findAll();
	}


	@Override
	public void unfollow(long id) {
		followRepo.deleteById(id);
		return;
	}

}
