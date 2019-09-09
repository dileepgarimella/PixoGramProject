package com.sba.pixogram.service;

import java.util.List;

import com.sba.pixogram.entity.Media;

public interface MediaService {

	public List<Media> getUsersMedia(int userId);

	public Media postMedia(Media m);
}
