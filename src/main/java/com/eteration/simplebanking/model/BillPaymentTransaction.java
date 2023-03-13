package com.eteration.simplebanking.model;

public class BillPaymentTransaction {

    public BillPaymentTransaction(double payee){

        this.payee = payee;
    }

    private double payee;

    public double getPayee() {
        return payee;
    }

    public void setPayee(double payee) {
        this.payee = payee;
    }

}
