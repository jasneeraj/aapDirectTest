package com.neeraj.test.model;

public class BillingAddress{
	
	private long id;
	private String first_name;
	private String last_name;
	private String street1;
	private String city;
	private String country;
	private String state;
	private String zipcode;
	private long phone;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "BillingAddress [id=" + id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", street1=" + street1
				+ ", city=" + city + ", country=" + country + ", state="
				+ state + ", zipcode=" + zipcode + ", phone=" + phone + "]";
	}
	
	
	public void add(BillingAddress billingAddress) {
		
		
	}
	

}