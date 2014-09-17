package com.gurhan.util;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private int id;
	private String country;
	
	public User(String name, String email, String country, int id) {
		this.name = name ;
		this.email = email; 
		this.country = country;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
	    return "Ad="+this.name + ", Email="+this.email+", Country" + this.country ;
	}
}
