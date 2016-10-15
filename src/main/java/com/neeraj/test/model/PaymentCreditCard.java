package com.neeraj.test.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentCreditCard implements Payment{
	
	private String paymentMethod = "CREDIT_CARD";
	private long paymentPlanId;
	private String name;
	private String number;
	private int expirationMonth;
	private int expirationYear;
	private int securityCode;
	private String type;
	
	
	private List<BillingAddress> billingAddress = new ArrayList<BillingAddress>();

	public List<BillingAddress> getBillingAddress() {
		return billingAddress;
	}
	
	public void addBillingAddress(BillingAddress billingAddress) {
		billingAddress.add(billingAddress);
	}
	
	public PaymentCreditCard(long id, String name,
			String number, int expirationMonth, int expirationYear,
			int securityCode, String type, List<BillingAddress> billingAddress) {
		this.paymentPlanId = id;
		this.name = name;
		this.number = number;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.securityCode = securityCode;
		this.type = type;
		this.billingAddress = billingAddress;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public long getPaymentPlanId() {
		return paymentPlanId;
	}

	public void setPaymentPlanId(long id) {
		this.paymentPlanId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public int getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBillingAddress(List<BillingAddress> billingAddress) {
		this.billingAddress = billingAddress;
	}

	
	@Override
	public String toString() {
		return "PaymentCreditCard [paymentMethod=" + paymentMethod + ", paymentPlanId="
				+ paymentPlanId + ", name=" + name + ", number=" + number
				+ ", expirationMonth=" + expirationMonth + ", expirationYear="
				+ expirationYear + ", securityCode=" + securityCode + ", type="
				+ type + ", billingAddress=" + billingAddress + "]";
	}

	
	public void getPaymentDetails() {
		return;
	}

	List<PaymentCreditCard> paymentCardList = new ArrayList<PaymentCreditCard>();
	
	public void addPaymentCreditCard(PaymentCreditCard paymentMethod) {
		paymentCardList.add(paymentMethod);
	}

	


}