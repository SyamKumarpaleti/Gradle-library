package com.example.libproj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String contact;

	


	public int getId() {
		return id;
	}


	public void setId(int id2) {
		this.id = id2;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	

	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact=" + contact +  "]";
	}
	


}
