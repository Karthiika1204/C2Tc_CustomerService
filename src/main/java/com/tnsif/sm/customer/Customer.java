package com.tnsif.sm.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
     public class Customer 
      {
	
		private Integer customerId;
		private String name;
		private String email;
		private String phoneNumber;
		private String address;
		public Customer() {
		
		
	   }
	
	public Customer(Integer customerId, String name, String email, String phoneNumber, String address) 
	{
		
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	 }
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public Integer getCustomerId() 
	{
		return customerId;
	}
	public void setCustomerId(Integer customerId)
	{
		this.customerId = customerId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}