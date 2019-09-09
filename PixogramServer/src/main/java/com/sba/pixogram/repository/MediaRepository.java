package com.sba.pixogram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sba.pixogram.entity.Media;
import com.sba.pixogram.entity.UploadPic;

public interface MediaRepository extends CrudRepository<Media, Long> {

	UploadPic save(UploadPic dbFile);

	@Query(value=" select f from UploadPic f where f.userId=?1")
	public List<UploadPic> findById( long fileId);

	

}
