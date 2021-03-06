package com.neeraj.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.neeraj.test.model.*;
import com.neeraj.test.service.*;

@RestController
public class CompaniesController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/company/", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> listAllCompanyies() {
		List<Company> company = companyService.findAllCompany();
		if(company.isEmpty()){
			return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Company>>(company, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> getCompany(@PathVariable("id") String id) {
		System.out.println("Fetching Company with id " + id);
		Company company = companyService.findById(id);
		if (company == null) {
			System.out.println("Company with id " + id + " not found");
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/company/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCompany(@RequestBody Company company, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Company " + company.getName());

		if (companyService.isCompanyExist(company)) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		companyService.saveCompany(company);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/company/{id}").buildAndExpand(company.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Company> updateCompany(@PathVariable("id") String id, @RequestBody Company company) {
		System.out.println("Updating Company " + id);
		
		Company currentCompany = companyService.findById(id);
		
		if (currentCompany==null) {
			System.out.println("Company with id " + id + " not found");
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}

		currentCompany.setName(company.getName());
		currentCompany.setWebsite(company.getWebsite());
		
		companyService.updateCompany(currentCompany);
		return new ResponseEntity<Company>(currentCompany, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Company> deleteCompany(@PathVariable("id") String id) {
		System.out.println("Fetching & Deleting Company with id " + id);

		Company company = companyService.findById(id);
		if (company == null) {
			System.out.println("Unable to delete. Company with id " + id + " not found");
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}

		companyService.deleteCompanyById(id);
		return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
	}

	
	@RequestMapping(value = "/company/", method = RequestMethod.DELETE)
	public ResponseEntity<Company> deleteAllCompanys() {
		System.out.println("Deleting All Companys");

		companyService.deleteAllCompany();
		return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
	}

}
