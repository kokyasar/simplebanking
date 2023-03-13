package com.eteration.simplebanking.model;

public class PhoneBillPaymentTransaction extends BillPaymentTransaction{

    public PhoneBillPaymentTransaction(String gsm, String phoneNumber ,double payee){
        super(payee);
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;
    private String gsm;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }
}
