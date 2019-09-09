package com.sba.pixogram.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sba.pixogram.entity.Login;
import com.sba.pixogram.entity.User;
import com.sba.pixogram.repository.LoginRepository;
import com.sba.pixogram.repository.UserRepository;
import com.sba.pixogram.service.UserService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	

//	@Autowired
//	UserRepository userRepository;
//
//
//	@Autowired
//	LoginRepository loginRepository;
//
//	
	
	List<User> lu=new ArrayList<User>();
	
	@GetMapping(path = "/user")
	public List<Login> getUsers() {
	
		
		
		return userService.getUsersList();
	}
	
	
	@GetMapping(path = "/users/{userId}")
	public List<Login> getUsers(@PathVariable Long userId) {
		//System.out.println("Get all Users...");
		
		System.out.print(userService.getUsers(userId));
		return userService.getUsers(userId);
	}

	@PostMapping(path = "/user/create")
	public User createUser(@RequestBody User user) {
		System.out.println("Creating User");
		User _user = userService.createUser(user);
		Login log=new Login(user.getFirstname(),user.getLastname(),user.getUsername(),user.getPassword(),user.getEmail());
		Login login=userService.createlogin(log);
		return _user;
	}

	@GetMapping(path = "/user/{userId}")
	public User getUserById(@PathVariable Long userId) {
		//System.out.println("Get user with id " + userId);
		return userService.getUserById(userId);
	}

	@GetMapping(path = "/user/{userId}/{fId}")
	public void Follow(@PathVariable Long userId,@PathVariable Long fId)
	{
		
	User u=userService.getUserById(userId);

	User f=userService.getUserById(fId);
	
	lu.add(f);
	u.setFollowOf(lu);
		userService.FollowUser(u);
	
	}
	
	@GetMapping(path = "/user1/{userId}")
	public List<Login> Followers(@PathVariable Long userId)
	{
		
	//User u=userService.getUserById(userId);

	//User f=userService.getUserById(fId);
	
//	lu.add(f);
	//u.setFollowOf(lu);
		
		List<Login> l=new ArrayList<Login>();
		//	l = loginRepository.Followers(userId);
		
		return userService.Followers(userId);
	
	}
	@GetMapping(path = "/user2/{userId}")
	public List<Login> Following(@PathVariable Long userId)
	{
		
	//User u=userService.getUserById(userId);

	//User f=userService.getUserById(fId);
	
//	lu.add(f);
	//u.setFollowOf(lu);
		
		List<Login> l=new ArrayList<Login>();
		//	l = loginRepository.Followers(userId);
		
		return userService.Following(userId);
	
	}
	
	
}
