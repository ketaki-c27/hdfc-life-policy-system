package com.hdfclife.model;

public class EndowmentPolicy extends Policy {

    public EndowmentPolicy(
            String policyNumber,
            String customer,
            int basePremium,
            String status) {

        super(policyNumber, customer, basePremium, status);
    }

    @Override
    public String getType() {
        return "ENDOWMENT";
    }
}