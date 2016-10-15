package com.neeraj.test.service;

import java.util.List;

import com.neeraj.test.model.PaymentCreditCard;

public interface PaymentCreditCardService {
	
	PaymentCreditCard findById(long id);
	
	void savePaymentCreditCard(PaymentCreditCard paymentCreditCard);
	
	void deletePaymentCreditCardById(long id);

	List<PaymentCreditCard> findAllPaymentCreditCards();

}
