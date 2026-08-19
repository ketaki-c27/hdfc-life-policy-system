package com.hdfclife.model;

public class TermLifePolicy extends Policy {

    public TermLifePolicy(
            String policyNumber,
            String customer,
            int basePremium,
            String status) {

        super(policyNumber, customer, basePremium, status);
    }

    @Override
    public String getType() {
        return "TERM";
    }
}