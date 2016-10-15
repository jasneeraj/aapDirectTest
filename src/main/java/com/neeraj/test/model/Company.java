package com.neeraj.test.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
	
	private String id;
	
	private String name;
	
	private CompanySize size;
	
	private String website;
	
	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}
	public void addUser(User user) {
		users.add(user);
	}
	
	public Company(){}
	public Company(String id, String name, String website, CompanySize size){
		this.id  	= id;
		this.name = name;
		this.website = website;
		this.size = size;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSize() {
		return size.toString();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setSize(CompanySize size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", website=" + website + "]";
	}


}