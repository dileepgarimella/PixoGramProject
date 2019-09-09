package com.sba.pixogram.service;

import java.util.List;


import com.sba.pixogram.entity.Blocked;


public interface BlockedService {
	
	public List<Blocked> getAllBlocked(); 
	
	public void unblockUser(Long id);
	
	public Blocked blockUser(Blocked block);
	
}
