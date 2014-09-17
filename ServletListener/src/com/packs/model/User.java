package com.packs.model;

public class User {
	private String name;
	private String surName;
	private int age;
	
	public User(String name, String surName, int age){
		this.name = name;
		this.surName = surName;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return "name: " + this.name + "\nsurname: " + this.surName + "\nage: " + this.age;
	}
	
}
