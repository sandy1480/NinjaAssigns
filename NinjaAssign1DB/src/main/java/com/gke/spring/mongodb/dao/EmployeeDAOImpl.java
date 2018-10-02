package com.gke.spring.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gke.spring.mongodb.model.Employee;
import com.mongodb.WriteResult;

public class EmployeeDAOImpl implements EmployeeDAO {

	private MongoOperations mongoOps;
	private static final String Employee_COLLECTION = "Employee";
	
	public EmployeeDAOImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}
	
	@Override
	public void create(Employee p) {
		this.mongoOps.insert(p, Employee_COLLECTION);
	}

	@Override
	public Employee readById(int no) {
		Query query = new Query(Criteria.where("no").is(no));
		return this.mongoOps.findOne(query, Employee.class, Employee_COLLECTION);
	}

	@Override
	public void update(Employee p) {
		this.mongoOps.save(p, Employee_COLLECTION);
	}

	@Override
	public int deleteById(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> getAll() {
		return this.mongoOps.findAll(Employee.class, Employee_COLLECTION);
		}

}
