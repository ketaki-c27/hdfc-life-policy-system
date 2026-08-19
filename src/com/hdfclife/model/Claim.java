package com.hdfclife.model;

public final class Claim
        implements Comparable<Claim> {

    private final String policyNo;
    private final int claimAmount;
    private final Urgency urgency;
    private final String hospitalName;
    private final String remarks;

    private ClaimStatus status;

    Claim(Builder builder) {

        this.policyNo =
                builder.policyNo;

        this.claimAmount =
                builder.claimAmount;

        this.urgency =
                builder.urgency;

        this.hospitalName =
                builder.hospitalName;

        this.remarks =
                builder.remarks;

        this.status =
                ClaimStatus.SUBMITTED;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public int getClaimAmount() {
        return claimAmount;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getRemarks() {
        return remarks;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void updateStatus(
            ClaimStatus status) {

        if (status == null) {
            throw new IllegalArgumentException(
                    "Claim status cannot be null");
        }

        this.status = status;
    }

    @Override
    public int compareTo(Claim other) {

        return Integer.compare(
                urgency.getPriority(),
                other.urgency.getPriority());
    }
}