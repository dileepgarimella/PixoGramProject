package com.sba.pixogram.service;

import java.util.List;
import java.util.Optional;

import com.sba.pixogram.entity.Login;
import com.sba.pixogram.entity.User;

public interface UserService {

	public List<Login> getUsers(Long id);
	
	public User createUser(User user);
	
	 public User getUserById(Long userId);

	public List<Login> getUsersList(); 
	
	public User FollowUser(User u);

	public Login createlogin(Login log);

	public List<Login> Followers(Long userId);

	public List<Login> Following(Long userId);
}
