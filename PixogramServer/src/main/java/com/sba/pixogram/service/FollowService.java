package com.sba.pixogram.service;

import java.util.List;

import com.sba.pixogram.entity.Follow;

public interface FollowService {

	public Follow follow(Follow follow);

	public List<Follow> getAll();

	public void unfollow(long id);
}
