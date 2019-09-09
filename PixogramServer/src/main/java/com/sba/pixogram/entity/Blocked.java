package com.sba.pixogram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "blocked")
@SequenceGenerator(name = "seq4", initialValue = 1, allocationSize = 100)
public class Blocked {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq4")
	private long id;

	@Column
	private long userId;

	@Column
	private long blockedId;

	public Blocked() {

	}

	public Blocked(long userId, long blockedId) {
		this.userId = userId;
		this.blockedId = blockedId;
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

	public long getBlockedId() {
		return blockedId;
	}

	public void setBlockedId(long blockedId) {
		this.blockedId = blockedId;
	}

	@Override
	public String toString() {
		return "Blocked [id=" + id + ", userId=" + userId + ", blockedId=" + blockedId + "]";
	}

}
