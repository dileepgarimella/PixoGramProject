package com.sba.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sba.pixogram.entity.Media;
import com.sba.pixogram.service.MediaService;
import com.sba.pixogram.service.StorageService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MediaController {

	@Autowired
	MediaService mediaService;
	
	@Autowired
	StorageService storageService;
	
	List<String> files = new ArrayList<String>();

	@GetMapping(path = "/media/{userId}")
	public List<Media> getUsersMedia(@PathVariable int userId) {
		System.out.println("Get all media for the user " + userId);
		List<Media> medias = mediaService.getUsersMedia(userId);
		List<Media> _medias = new ArrayList<>();
		
		System.out.println(userId);
		System.out.println(medias);
		for (Media media : medias) {
			if (media.getUserId() == userId) {
				_medias.add(media);
			}
		}
		System.out.println(_medias);
		return _medias;
	}
}
