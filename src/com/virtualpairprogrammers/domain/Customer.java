package com.virtualpairprogrammers.domain;

import java.io.Serializable;

// A very basic stub of a customer class, just for illustration.
public class Customer implements Serializable
{
	public Customer()
	{
		
	}
	public Customer(String name) 
	{
		this.name = name;
	}
	private String name;
	private String id;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
}
