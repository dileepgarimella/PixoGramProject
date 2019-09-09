package com.sba.pixogram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sba.pixogram.entity.Login;
import com.sba.pixogram.entity.User;

public interface LoginRepository extends CrudRepository<Login, Long>  {

	@Query(value=" select f from Login f where f.id !=?1")
	public List<Login> getUsers(long id);
	
	
@Query(value="select l from Login l where l.id in (select f.friend_id from Login l, followers f where l.id=?1 and l.id=f.user_id)")
	public List<Login> Followers(Long userId);

@Query(value=" select l from Login l where l.id in (select f.user_id from Login l, followers f where l.id!=?1 and f.friend_id=?1)")
public List<Login> Following(Long userId);
	
}
