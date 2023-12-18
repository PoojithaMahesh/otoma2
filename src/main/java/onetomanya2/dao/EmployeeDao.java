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
//			i just want to save this company and also i want to updare company's list of employee
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
}
