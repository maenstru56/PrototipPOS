package com.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale {
    private List<SalesLineItem> lineItems = new ArrayList();
    private Date date = new Date();
    private boolean isComplete = false;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    private Payment payment;

    public double getBalance() {
        return payment.getAmount() - getTotal();
    }

    public void becomeComplete() {
        isComplete = true;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void makeLineItem(ProductDescription desc, int quantity) {
        lineItems.add(new SalesLineItem(desc, quantity));
    }

    public double getTotal() {
        double total = 0;
        double subtotal = 0;

        for ( SalesLineItem lineItem : lineItems ) {
            subtotal = lineItem.getSubtotal();
            total += subtotal;
        }

        return total;
    }

    public void makePayment(double cashTendered, String paymentType) {
        payment = new Payment(paymentType, cashTendered);
    }
}
