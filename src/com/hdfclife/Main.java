package com.hdfclife;

import com.hdfclife.config.AppConfig;
import com.hdfclife.exception.*;
import com.hdfclife.factory.PolicyFactory;
import com.hdfclife.model.*;
import com.hdfclife.observer.*;
import com.hdfclife.service.*;
import com.hdfclife.store.PolicyStore;
import com.hdfclife.strategy.*;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                "Company: "
                        + AppConfig.INSTANCE
                        .getCompanyName());

        PolicyStore store = new PolicyStore();

        store.add(
                PolicyFactory.create(
                        "TERM",
                        "HDFC-LIFE-1001",
                        "Anita Sharma",
                        18500,
                        "Active"
                )
        );

        store.add(
                PolicyFactory.create(
                        "ULIP",
                        "HDFC-LIFE-1002",
                        "Rahul Mehta",
                        42000,
                        "Active"
                )
        );

        store.add(
                PolicyFactory.create(
                        "ENDOWMENT",
                        "HDFC-LIFE-1003",
                        "Priya Nair",
                        27000,
                        "Lapsed"
                )
        );

        store.add(
                PolicyFactory.create(
                        "TERM",
                        "HDFC-LIFE-1004",
                        "Vikram Singh",
                        15200,
                        "Active"
                )
        );

        store.add(
                PolicyFactory.create(
                        "ULIP",
                        "HDFC-LIFE-1005",
                        "Sneha Patel",
                        36000,
                        "Active"
                )
        );

        store.add(
                PolicyFactory.create(
                        "ENDOWMENT",
                        "HDFC-LIFE-1006",
                        "Anita Sharma",
                        22000,
                        "Pending"
                )
        );

        System.out.println(
                "\nAll Policies:");

        store.printAllPolicies();

        System.out.println(
                "Unique customers: "
                        + store.getUniqueCustomerNames().size());

        Policy policy =
                store.findByPolicyNumber(
                        "HDFC-LIFE-1004");

        System.out.println(
                "Customer: "
                        + policy.getCustomer());

        System.out.println("Sorted policy numbers:");

        for (String key :
                store.getSortedPolicies().keySet()) {

            System.out.println(key);
        }

        PremiumCalculator calculator =
                new PremiumCalculator(
                        new TermPremiumStrategy());

        calculator.setStrategy(
                new UlipPremiumStrategy());

        Policy ulipPolicy =
                store.findByPolicyNumber(
                        "HDFC-LIFE-1002");

        int premium =
                calculator.calculate(
                        ulipPolicy.getBasePremium());

        System.out.println(
                "ULIP premium: " + premium);

        ClaimEventPublisher publisher =
                new ClaimEventPublisher();

        publisher.register(
                new InAppNotifier());

        publisher.register(
                new BranchLetterNotifier());

    }
}