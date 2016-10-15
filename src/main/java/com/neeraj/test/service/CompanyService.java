package com.neeraj.test.service;

import java.util.List;

import com.neeraj.test.model.Company;


public interface CompanyService {
	
	Company findById(String id);
	
	Company findByName(String name);
	
	void saveCompany(Company company);
	
	void updateCompany(Company company);

	List<Company> findAllCompany(); 

	void deleteCompanyById(String id);
	
	void deleteAllCompany();
	
	public boolean isCompanyExist(Company company);
	
}
