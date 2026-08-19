package com.hdfclife.service;

import com.hdfclife.config.AppConfig;
import com.hdfclife.exception.InvalidClaimException;
import com.hdfclife.model.Claim;
import com.hdfclife.observer.ClaimEventPublisher;
import com.hdfclife.strategy.PremiumStrategy;

public class ClaimService {

    private final PremiumStrategy premiumStrategy;
    private final ClaimEventPublisher publisher;
    private final AuditLogger auditLogger;

    public ClaimService(
            PremiumStrategy premiumStrategy,
            ClaimEventPublisher publisher,
            AuditLogger auditLogger) {

        this.premiumStrategy = premiumStrategy;
        this.publisher = publisher;
        this.auditLogger = auditLogger;
    }

    public void fileClaim(Claim claim) {

        if (claim.getClaimAmount() <= 0
                || claim.getClaimAmount()
                > AppConfig.INSTANCE
                .getMaxClaimAmount()) {

            throw new InvalidClaimException(
                    "Invalid claim amount: "
                            + claim.getClaimAmount()
                            + " (allowed: 1-"
                            + AppConfig.INSTANCE
                            .getMaxClaimAmount()
                            + ")");
        }

        auditLogger.log(claim);

        System.out.println(
                "Claim filed: "
                        + claim.getPolicyNo());
    }

    public void publishStatusChange(
            Claim claim) {

        publisher.notifyObservers(claim);
    }
}