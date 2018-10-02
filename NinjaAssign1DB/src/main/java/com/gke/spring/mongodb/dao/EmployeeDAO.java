package com.gke.spring.mongodb.dao;

import java.util.List;

import com.gke.spring.mongodb.model.Employee;

public interface EmployeeDAO {

	public void create(Employee p);
	
	public Employee readById(int id);
	
	public void update(Employee p);
	
	public List getAll();

	public int deleteById(int no);
}
