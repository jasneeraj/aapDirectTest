package com.neeraj.test.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neeraj.test.model.Company;
import com.neeraj.test.model.CompanySize;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	private static List<Company> companies;
	
	static{
		companies= populateDummyCompanies();
	}

	public List<Company> findAllCompany() {
		return companies;
	}
	
	public Company findById(String id) {
		for(Company cmp : companies){
			if(cmp.getId().equalsIgnoreCase(id)){
				return cmp;
			}
		}
		return null;
	}
	
	public Company findByName(String name) {
		for(Company cmp : companies){
			if(cmp.getName().equalsIgnoreCase(name)){
				return cmp;
			}
		}
		return null;
	}
	
	public void saveCompany(Company company) {
		company.setId(UUID.randomUUID().toString());
		companies.add(company);
	}

	public void updateCompany(Company company) {
		int index = companies.indexOf(company);
		companies.set(index, company);
	}

	public void deleteCompanyById(String id) {
		
		for (Iterator<Company> iterator = companies.iterator(); iterator.hasNext(); ) {
		    Company company = iterator.next();
		    if (company.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isCompanyExist(Company company) {
		return findByName(company.getName())!= null;
	}

	private static List<Company> populateDummyCompanies(){
		List<Company> company = new ArrayList<Company>();
		company.add(new Company(UUID.randomUUID().toString(),"myshop","www.myweb.com", CompanySize.ENTERPRISE));
		return company;
	}

	public void deleteAllCompany() {
		companies.clear();
	}
}
