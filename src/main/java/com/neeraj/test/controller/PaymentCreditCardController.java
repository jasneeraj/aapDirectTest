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
public class PaymentCreditCardController {

	@Autowired
	PaymentCreditCardService paymentCreditCardService;  //Service which will do all data retrieval/manipulation work
	
	@Autowired
	UserService userService;
	
	@Autowired
	CompanyService companyService;
	
	
	//-------------------Retrieve All paymentMethod--------------------------------------------------------
	
	@RequestMapping(value = "/paymentMethod/", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentCreditCard>> listAllParmentMethod() {
		List<PaymentCreditCard> paymentMethod = paymentCreditCardService.findAllPaymentCreditCards();
		if(paymentMethod.isEmpty()){
			return new ResponseEntity<List<PaymentCreditCard>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<PaymentCreditCard>>(paymentMethod, HttpStatus.OK);
	}


	//-------------------Retrieve Single Payment Method--------------------------------------------------------
	
	@RequestMapping(value = "/paymentMethod/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentCreditCard> getPaymentCreditCard(@PathVariable("id") long id) {
		System.out.println("Fetching Payment Method with id " + id);
		PaymentCreditCard paymentMethod = paymentCreditCardService.findById(id);
		if (paymentMethod == null) {
			System.out.println("PaymentCreditCard with id " + id + " not found");
			return new ResponseEntity<PaymentCreditCard>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PaymentCreditCard>(paymentMethod, HttpStatus.OK);
	}

	
	
	//-------------------Create a PaymentCreditCard--------------------------------------------------------
	
	
	public User getUser(@PathVariable("/user/{id}") String id, @RequestBody PaymentCreditCard paymentMethod) {
		User user = null;

	    try {
	    	user = userService.findById(id);
	    	paymentCreditCardService.savePaymentCreditCard(paymentMethod);
	    	paymentMethod.addPaymentCreditCard(paymentMethod);
	    } catch (Exception ex) {
	        System.out.println("Exception while validating user"+ ex);
	    }
	    return user;
	}
	
	@RequestMapping(value = "/paymentMethod/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPaymentCreditCard(@RequestBody PaymentCreditCard paymentMethod, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating PaymentCreditCard " + paymentMethod.getPaymentPlanId());

	/*	if (paymentCreditCardService.findById(paymentMethod)) {
			System.out.println("A Payment Method with Card number " + paymentMethod.getNumber() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}*/

		paymentCreditCardService.savePaymentCreditCard(paymentMethod);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/paymentMethod/{id}").buildAndExpand(paymentMethod.getPaymentPlanId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	//------------------- Delete a Payment Method --------------------------------------------------------
	
	@RequestMapping(value = "/paymentMethod/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deletePaymentCreditCard(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting PaymentCreditCard with id " + id);

		PaymentCreditCard paymentMethod = paymentCreditCardService.findById(id);
		if (paymentMethod == null) {
			System.out.println("Unable to delete. PaymentCreditCard with id " + id + " not found");
			return new ResponseEntity<Response>(new Response("Unable to delete. PaymentCreditCard with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}

		paymentCreditCardService.deletePaymentCreditCardById(id);
		return new ResponseEntity<Response>(HttpStatus.NO_CONTENT);
	}

}
