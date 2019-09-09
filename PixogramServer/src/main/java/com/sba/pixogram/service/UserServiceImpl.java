package com.sba.pixogram.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pixogram.entity.Login;
import com.sba.pixogram.entity.User;
import com.sba.pixogram.repository.LoginRepository;
import com.sba.pixogram.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	LoginRepository loginRepository;
	
	
	@Autowired
	EntityManager manager;	
	@Override
	public List<Login> getUsers(Long Id) {
		return (List<Login>) loginRepository.getUsers(Id);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	 @Override 
	 public User getUserById(Long userId) {
		 return userRepository.userfindById(userId); 
		 }

	@Override
	public List<Login> getUsersList() {
		// TODO Auto-generated method stub
		Query q=manager.createQuery("from Login");
		return  q.getResultList();	
		}

	@Override
	public User FollowUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public Login createlogin(Login log) {
		// TODO Auto-generated method stub
		return loginRepository.save(log);
	}

	@Override
	public List<Login> Followers(Long userId) {
		
		return loginRepository.Followers(userId);
	}

	@Override
	public List<Login> Following(Long userId) {
		// TODO Auto-generated method stub
		return loginRepository.Following(userId);
	}
	 
}
