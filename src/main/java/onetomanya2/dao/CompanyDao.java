package onetomanya2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanya2.dto.Company;
import onetomanya2.dto.Employee;

public class CompanyDao {
public EntityManager getEntityManager() {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	return entityManager;
}
public void saveCompany(Company company) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(company);
	entityTransaction.commit();
}

public void updateCompany(int id,Company company) {
	EntityManager entityManager=getEntityManager();
	Company dbCompany=entityManager.find(Company.class, id);
	if(dbCompany!=null) {
//		id is present then i can update the data
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		company.setId(id);
		company.setEmployees(dbCompany.getEmployees());
		entityManager.merge(company);
		entityTransaction.commit();}else {
		System.out.println("Sorry id is not present");
	}
}


public void findCompany(int id) {
	EntityManager entityManager=getEntityManager();
	Company dbCompany=entityManager.find(Company.class, id);
	if(dbCompany!=null) {
		System.out.println(dbCompany);
	}else {
		System.out.println("Sorry that id is not present");
	}
	
}

public void deleteCompany(int id) {
	EntityManager entityManager=getEntityManager();
	Company dbCompany=entityManager.find(Company.class, id);
	if(dbCompany!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbCompany);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry that id is not present");
		 
	}
}






















}
