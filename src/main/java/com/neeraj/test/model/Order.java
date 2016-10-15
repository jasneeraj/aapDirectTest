package com.neeraj.test.model;

public class Order {

	private String paymentPlanId;
	private OrderLine[] oderlines;
	
	public String getPaymentPlanId() {
		return paymentPlanId;
	}
	public void setPaymentPlanId(String paymentPlanId) {
		this.paymentPlanId = paymentPlanId;
	}
	public OrderLine[] getOderlines() {
		return oderlines;
	}
	public void setOderlines(OrderLine[] oderlines) {
		this.oderlines = oderlines;
	}

}
