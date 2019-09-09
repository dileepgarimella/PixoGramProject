package com.sba.pixogram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "follow")
@SequenceGenerator(name = "seq3", initialValue = 1, allocationSize = 100)
public class Follow {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq3")
	private long id;

	@Column
	private long userId;

	@Column
	private long followId;

	public Follow() {

	}

	public Follow(long userId, long followId) {
		this.userId = userId;
		this.followId = followId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getfollowId() {
		return followId;
	}

	public void setfollowId(long followId) {
		this.followId = followId;
	}

	@Override
	public String toString() {
		return "Followers [id=" + id + ", userId=" + userId + ", followId=" + followId + "]";
	}
	
	
}
