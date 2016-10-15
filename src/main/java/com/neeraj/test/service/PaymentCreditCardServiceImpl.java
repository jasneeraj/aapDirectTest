package com.neeraj.test.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neeraj.test.model.Company;
import com.neeraj.test.model.PaymentCreditCard;

@Service("paymentCreditCardService")
@Transactional
public class PaymentCreditCardServiceImpl implements PaymentCreditCardService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<PaymentCreditCard> paymentCreditCard;
	
	public void savePaymentCreditCard(PaymentCreditCard paymentMethod) {
		paymentMethod.setPaymentPlanId(counter.incrementAndGet());
		paymentCreditCard.add(paymentMethod);
	}

	public void deletePaymentCreditCardById(long id) {
		
		for (Iterator<PaymentCreditCard> iterator = paymentCreditCard.iterator();
				iterator.hasNext(); ) {
			PaymentCreditCard paymentMethod = iterator.next();
		    if (paymentMethod.getPaymentPlanId() == id) {
		        iterator.remove();
		    }
		}
	}
	

	public PaymentCreditCard findById(long id) {
		
		
		return null;
	}

	
	private static List<PaymentCreditCard> paymentCreditCards;
	
	public List<PaymentCreditCard> findAllPaymentCreditCards() {
		return paymentCreditCards;
	}
	


}
