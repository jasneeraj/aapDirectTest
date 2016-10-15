package com.neeraj.test.service;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neeraj.test.model.Company;
import com.neeraj.test.model.Subscription;

@Service("subscriptionService")
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Subscription> subscriptions;
	
	public Subscription findById(long id) {
		for(Subscription subscription : subscriptions){
			if(subscription.getId() == id){
				return subscription;
			}
		}
		return null;
	}
	
	public void saveSubscription(Subscription subscription) {
		subscription.setId(counter.incrementAndGet());
		subscriptions.add(subscription);
	}


	public void cancelSubscription(long id) {
		for (Iterator<Subscription> iterator = subscriptions.iterator(); iterator.hasNext(); ) {
			Subscription subscription = iterator.next();
		    if (subscription.getId() == id) {
		        iterator.remove();
		    }
		}
		
	}

}
