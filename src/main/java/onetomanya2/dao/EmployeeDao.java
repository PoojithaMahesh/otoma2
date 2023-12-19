package onetomanya2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanya2.dto.Company;
import onetomanya2.dto.Employee;

public class EmployeeDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveEmployee(int companyId,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Company dbCompany=entityManager.find(Company.class, companyId);
		
		if(dbCompany!=null) {
//			that company exist then i can add employes to this company
//			i just want to save this employee and also i want to update company's list of employee
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(employee);
//		update company details
//			first take companys the entire list
			List<Employee> employees=dbCompany.getEmployees();
//		employees :: inside this we are having old employee data
//			to this old employees data shall i add new employee
			employees.add(employee);
			
//			employees::old emp data and new employee data
			
			dbCompany.setEmployees(employees);
			
			entityTransaction.commit();
		}else {
			System.out.println("Sorry that id is not present");
		}
		
	}
	
	
	
	public void updateEmployee(int id,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
//			id is present and then i can update the data
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			employee.setId(id);
			entityManager.merge(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
		
		
		
	}
	
	
	public void findEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
	        System.out.println(dbEmployee);
		}else {
			System.out.println("Sorry id is not present");
		}
		
		
	}
	
	public void deleteEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
	       EntityTransaction entityTransaction=entityManager.getTransaction();
	       entityTransaction.begin();
	       entityManager.remove(dbEmployee);
	       entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
