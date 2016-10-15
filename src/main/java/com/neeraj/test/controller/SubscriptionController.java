package com.neeraj.test.controller;



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
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;  //Service which will do all data retrieval/manipulation work
	
	@Autowired
	UserService userService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	PaymentCreditCardService paymentCreditCardService;
	
	
	//-------------------Retrieve Single Subscription--------------------------------------------------------
	
	@RequestMapping(value = "/subscription/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Subscription> getSubscription(@PathVariable("id") long id) {
		System.out.println("Fetching Subscription with id " + id);
		Subscription subscription = subscriptionService.findById(id);
		if (subscription == null) {
			System.out.println("Subscription with id " + id + " not found");
			return new ResponseEntity<Subscription>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Subscription>(subscription, HttpStatus.OK);
	}

	
	
	//-------------------Create a Subscription--------------------------------------------------------
	
	
	public User getUser(@PathVariable("/paymentCreditCard/{id}") String id, @RequestBody Subscription subscription) {
		User user = null;

	    try {
	    	user = userService.findById(id);
	    	subscriptionService.saveSubscription(subscription);
	    	((SubscriptionService) subscription).saveSubscription(subscription);
	    } catch (Exception ex) {
	        System.out.println("Exception while validating user"+ ex);
	    }
	    return user;
	}
	
	@RequestMapping(value = "/subscription/", method = RequestMethod.POST)
	public ResponseEntity<Void> createSubscription(@RequestBody Subscription subscription, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Subscription " + subscription.getId());

		subscriptionService.saveSubscription(subscription);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/subscription/{id}").buildAndExpand(subscription.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	//------------------- Cancel a Subscription --------------------------------------------------------
	
	@RequestMapping(value = "/subscription/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteSubscription(@PathVariable("id") long id) {
		System.out.println("Fetching & Cancelling Subscription with id " + id);

		Subscription subscription = subscriptionService.findById(id);
		if (subscription == null) {
			System.out.println("Unable to delete. Subscription with id " + id + " not found");
			return new ResponseEntity<Response>(new Response("Unable to delete. Subscription with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}

		subscriptionService.cancelSubscription(id);
		return new ResponseEntity<Response>(HttpStatus.NO_CONTENT);
	}

}
