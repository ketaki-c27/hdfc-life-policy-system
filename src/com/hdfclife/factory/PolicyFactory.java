package com.hdfclife.factory;

import com.hdfclife.exception.UnknownPolicyTypeException;
import com.hdfclife.model.EndowmentPolicy;
import com.hdfclife.model.Policy;
import com.hdfclife.model.TermLifePolicy;
import com.hdfclife.model.UlipPolicy;

public final class PolicyFactory {

    private PolicyFactory() {
    }

    public static Policy create(
            String type,
            String policyNo,
            String customer,
            int premium,
            String status) {

        if ("TERM".equalsIgnoreCase(type)) {
            return new TermLifePolicy(
                    policyNo,
                    customer,
                    premium,
                    status);
        }

        if ("ULIP".equalsIgnoreCase(type)) {
            return new UlipPolicy(
                    policyNo,
                    customer,
                    premium,
                    status);
        }

        if ("ENDOWMENT".equalsIgnoreCase(type)) {
            return new EndowmentPolicy(
                    policyNo,
                    customer,
                    premium,
                    status);
        }

        throw new UnknownPolicyTypeException(
                "Unknown policy type: " + type);
    }
}