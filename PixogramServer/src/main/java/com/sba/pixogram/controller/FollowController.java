package com.sba.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sba.pixogram.entity.Follow;
import com.sba.pixogram.service.FollowService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FollowController {

	@Autowired
	FollowService followService;

	@PostMapping(path = "/follow")
	public Follow follow(@RequestBody Follow follow) {
		System.out.println("Added follower");
		Follow _follow = new Follow();
		List<Follow> _allFollowers = (List<Follow>) followService.getAll();
		for (Follow f : _allFollowers) {
			if (f.getUserId() == follow.getUserId() && f.getfollowId() == follow.getfollowId()) {
				System.out.println("already a follower");
				_follow = f;
			} else {
				_follow = followService.follow(follow);
			}
		}
		return _follow;
	}

	@GetMapping(path = "/followings/{userId}")
	public List<Follow> followings(@PathVariable Long userId) {

		List<Follow> follow = (List<Follow>) followService.getAll();
		List<Follow> _follow = new ArrayList<>();

		for (Follow f : follow) {
			if (f.getUserId() == userId)
				_follow.add(f);
		}
		return _follow;

	}

	@GetMapping(path = "/followers/{followId}")
	public List<Follow> followers(@PathVariable("followId") Long followId) {

		List<Follow> follow = (List<Follow>) followService.getAll();
		List<Follow> _follow = new ArrayList<>();

		for (Follow f : follow) {
			if (f.getfollowId() == followId)
				_follow.add(f);
		}

		return _follow;
	}

	@DeleteMapping(path = "/unfollow/{userId}/{followId}")
	public ResponseEntity<String> unfollow(@PathVariable("userId") long userId,
			@PathVariable("followId") long followId) {
		System.out.println("unfollow " + userId + " " + followId);
		List<Follow> follow = (List<Follow>) followService.getAll();
		List<Follow> _follow = new ArrayList<>();
		System.out.println(follow);
		for (Follow f : follow) {
			if (f.getUserId() == userId)
				_follow.add(f);
		}
		System.out.println(_follow);
		for (Follow f : _follow) {
			if (f.getfollowId() == followId) {
				System.out.println(f.getId());
				followService.unfollow(f.getId());
			}
		}

		return new ResponseEntity<>("Unfollowed", HttpStatus.OK);
	}
}
