package com.neeraj.test.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class Subscription {
	
	private int id;
	
	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}
	public void addUser(User user) {
		users.add(user);
	}
	
	public Subscription(){}
	public Subscription(int id){
		this.id = id; 
	}
	
	public int getId() {
		return id;
	}

	public void setId(long la) {
		this.id = (int) la;
	}
	
	

	
	
	
	
	
	
	

}