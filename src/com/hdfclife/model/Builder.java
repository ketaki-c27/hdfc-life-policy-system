package com.hdfclife.model;

public class Builder {

    final String policyNo;
    final int claimAmount;
    final Urgency urgency;

    String hospitalName;
    String remarks;

    public Builder(
            String policyNo,
            int claimAmount,
            Urgency urgency) {

        this.policyNo = policyNo;
        this.claimAmount = claimAmount;
        this.urgency = urgency;
    }

    public Builder hospitalName(
            String hospitalName) {

        this.hospitalName = hospitalName;

        return this;
    }

    public Builder remarks(
            String remarks) {

        this.remarks = remarks;

        return this;
    }

    public Claim build() {

        return new Claim(this);
    }

}