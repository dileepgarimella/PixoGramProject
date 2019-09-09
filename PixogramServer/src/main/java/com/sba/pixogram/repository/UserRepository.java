package com.sba.pixogram.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sba.pixogram.entity.Login;
import com.sba.pixogram.entity.UploadPic;
import com.sba.pixogram.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	//@Autowired
	//private EntityManager man;
	
	@Query(value=" select f from User f where f.id !=?1")
	public List<User> getUsers(long id);
	
	@Query(value=" select f from User f where f.id=?1")
	public User userfindById( long fileId);

	
	@Query(value=" select f from User f")
	public List<Login> getUserslist();
	
	
}
