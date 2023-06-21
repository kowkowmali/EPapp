package com.example.haftsadbist.models;

public class ChargeRequest {
    public String MobileNo, mid;
    public float OperatorType, AmountPure;

    public ChargeRequest(String mobileNo, float operatorType, float amountPure, String mid) {
        this.MobileNo = mobileNo;
        this.OperatorType = operatorType;
        this.AmountPure = amountPure;
        this.mid = mid;
    }
}
