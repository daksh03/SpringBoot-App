package com.example.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
	/*
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	 */
    private String username;
    private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//paramertised constructor me values add ki h
	public User(String username, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.username= username;
		this.password = password;
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
	
	//removed this keyword from from setters

    // Getters and setters

    // Constructors
}


