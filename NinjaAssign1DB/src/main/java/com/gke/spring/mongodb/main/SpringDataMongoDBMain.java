package com.gke.spring.mongodb.main;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gke.spring.mongodb.model.Employee;
import com.mongodb.MongoClient;

public class SpringDataMongoDBMain {

	public static final String DB_NAME = "mongoDBsAssign";
	public static final String Employee_COLLECTION = "Employee";
	public static final String MONGO_HOST = "35.177.39.42";
	public static final int MONGO_PORT = 27017;

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient(
					MONGO_HOST, MONGO_PORT);
			MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
			Employee p = new Employee("116", "Girish", "GGG",7);
			mongoOps.insert(p, Employee_COLLECTION);

			Employee p1 = mongoOps.findOne(
					new Query(Criteria.where("id").is("116")),
					Employee.class, Employee_COLLECTION);

			System.out.println(p1);
			
			mongoOps.dropCollection(Employee_COLLECTION);
			mongo.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
