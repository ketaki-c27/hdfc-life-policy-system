package com.hdfclife.model;

public class UlipPolicy extends Policy {

    public UlipPolicy(
            String policyNumber,
            String customer,
            int basePremium,
            String status) {

        super(policyNumber, customer, basePremium, status);
    }

    @Override
    public String getType() {
        return "ULIP";
    }
}