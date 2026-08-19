package com.hdfclife.store;

import com.hdfclife.exception.PolicyNotFoundException;
import com.hdfclife.model.Policy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PolicyStore {

    private final ArrayList<Policy> policies
            = new ArrayList<>();

    private final HashSet<String> uniqueCustomerNames
            = new HashSet<>();

    private final HashMap<String, Policy> policyByNumber
            = new HashMap<>();

    private final TreeMap<String, Policy> sortedPolicies
            = new TreeMap<>();

    public void add(Policy policy) {

        policies.add(policy);

        uniqueCustomerNames.add(
                policy.getCustomer());

        policyByNumber.put(
                policy.getPolicyNumber(),
                policy);

        sortedPolicies.put(
                policy.getPolicyNumber(),
                policy);
    }

    public void printAllPolicies() {

        Iterator<Policy> iterator =
                policies.iterator();

        while (iterator.hasNext()) {

            Policy policy = iterator.next();

            System.out.println(policy);
        }
    }

    public Policy findByPolicyNumber(
            String policyNumber) {

        Policy policy =
                policyByNumber.get(policyNumber);

        if (policy == null) {
            throw new PolicyNotFoundException(
                    "Policy not found: "
                            + policyNumber);
        }

        return policy;
    }

    public Set<String> getUniqueCustomerNames() {
        return uniqueCustomerNames;
    }

    public Map<String, Policy> getSortedPolicies() {
        return sortedPolicies;
    }

}