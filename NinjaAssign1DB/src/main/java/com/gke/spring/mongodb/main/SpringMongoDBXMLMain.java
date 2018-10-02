package com.gke.spring.mongodb.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gke.spring.mongodb.dao.EmployeeDAO;
import com.gke.spring.mongodb.model.Employee;;

public class SpringMongoDBXMLMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		EmployeeDAO EmployeeDAO = ctx.getBean("EmployeeDAO", EmployeeDAO.class);
		
		Employee p = new Employee(null, "Girish", "Eduru",11);
		
		//create
		EmployeeDAO.create(p);
		System.out.println("Generated ID="+p.getId());
		
		//read
		Employee p1 = EmployeeDAO.readById(p.getNo());
		System.out.println("Retrieved Person="+p1);
		
		//update
//		p1.setFirstname("David");
//		EmployeeDAO.update(p1);
//		Employee temp = EmployeeDAO.readById(p1.getId());
//		System.out.println("Retrieved Person after update="+temp);
		
		
		
		ctx.close();

	}
	
	public static EmployeeDAO getMongo(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		EmployeeDAO EmployeeDAO = ctx.getBean("EmployeeDAO", EmployeeDAO.class);
		return EmployeeDAO;
	}

}
