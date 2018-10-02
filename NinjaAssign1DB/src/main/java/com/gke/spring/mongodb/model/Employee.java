package com.gke.spring.mongodb.model;

import org.springframework.data.annotation.Id;

public class Employee {

	//id will be used for storing MongoDB _id
	@Id
	private String id;
	
	private String firstname;
	private String lastname;
	private int no;
	
	public Employee(){}
	public Employee(String i, String fn, String ln, int n){
		this.id=i;
		this.firstname=fn;
		this.lastname=ln;
		this.no=n;

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", no=" + no + "]";
	}
}
