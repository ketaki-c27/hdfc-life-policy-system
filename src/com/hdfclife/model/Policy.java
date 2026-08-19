package com.hdfclife.model;

public abstract class Policy {

    private final String policyNumber;
    private final String customer;
    private final int basePremium;
    private final String status;

    protected Policy(
            String policyNumber,
            String customer,
            int basePremium,
            String status) {

        this.policyNumber = policyNumber;
        this.customer = customer;
        this.basePremium = basePremium;
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public int getBasePremium() {
        return basePremium;
    }

    public String getStatus() {
        return status;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return policyNumber + " | "
                + customer + " | "
                + getType() + " | "
                + basePremium + " | "
                + status;
    }
}