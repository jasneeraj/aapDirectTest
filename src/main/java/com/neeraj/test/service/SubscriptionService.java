package com.neeraj.test.service;

import com.neeraj.test.model.Subscription;

public interface SubscriptionService {
	
	void saveSubscription(Subscription subscription);
	
	void cancelSubscription(long id);

	Subscription findById(long id);
	
}
