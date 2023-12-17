package com.RestAPIs.restfulwebservice.Server.Entity;

import java.time.LocalDate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	@Size(min = 2, message = "You must enter at least 2 characters")
	private String username;

	@Column(name = "birthdate")
	@Past
	private LocalDate birthdate;

	@OneToMany(mappedBy = "user") // 1 user can have many posts
	@JsonIgnore
	private List<Post> posts;

	public User() {
		super();
	}

	public User(int id, String username, LocalDate birthdate) {
		super();
		this.id = id;
		this.username = username;
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> post) {
		this.posts = post;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", birthdate=" + birthdate + "]";
	}

}
