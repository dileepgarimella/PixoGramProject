package com.sba.pixogram.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user") 
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;	
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	
	
	public List<User> getFollow() {
		return follow;
	}

	public void setFollow(List<User> follow) {
		this.follow = follow;
	}

	public List<User> getFollowOf() {
		return followOf;
	}

	public void setFollowOf(List<User> followOf) {
		this.followOf = followOf;
	}


	@ManyToMany
	@JoinTable(name="followers",joinColumns=@JoinColumn(name="friendId"),inverseJoinColumns=@JoinColumn(name="userId"))
	private List<User> follow;
	
	@ManyToMany
	@JoinTable(name="followers",joinColumns=@JoinColumn(name="userId"),inverseJoinColumns=@JoinColumn(name="friendId"))
	private List<User> followOf;
	
//	
//	public User() {
//	}
//
//	public User(String firstname, String lastname, String username, String password, String email) {
//		super();
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.username = username;
//		this.password = password;
//		this.email = email;
//	}
//	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}

	
}
