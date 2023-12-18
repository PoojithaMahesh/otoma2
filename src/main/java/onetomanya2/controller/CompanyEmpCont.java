package onetomanya2.controller;

import onetomanya2.dao.CompanyDao;
import onetomanya2.dao.EmployeeDao;
import onetomanya2.dto.Company;
import onetomanya2.dto.Employee;

public class CompanyEmpCont {
public static void main(String[] args) {
	
//	Company company=new Company();
//	company.setId(1);
//	company.setName("TYSS");
//	company.setGst("TYSS@123");
//	
//	CompanyDao companyDao=new CompanyDao();
//	companyDao.saveCompany(company);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Employee employee=new Employee();
	employee.setId(2);
	employee.setName("sandhya");
	employee.setAddress("pune");
	
	EmployeeDao employeeDao=new EmployeeDao();
	employeeDao.saveEmployee(1, employee);
}
}
