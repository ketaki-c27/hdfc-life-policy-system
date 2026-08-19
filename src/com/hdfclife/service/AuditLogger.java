package com.hdfclife.service;

import com.hdfclife.exception.PolicyServiceException;
import com.hdfclife.model.Claim;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AuditLogger
        implements AutoCloseable {

    private boolean closed;

    public void log(Claim claim) {

        if (closed) {
            throw new PolicyServiceException(
                    "AuditLogger is already closed");
        }

        try (
                FileWriter fileWriter =
                        new FileWriter(
                                "audit.log",
                                true);

                PrintWriter writer =
                        new PrintWriter(fileWriter)
        ) {

            writer.println(
                    "Filed claim | policy="
                            + claim.getPolicyNo()
                            + " | amount="
                            + claim.getClaimAmount()
                            + " | urgency="
                            + claim.getUrgency()
                            + " | status="
                            + claim.getStatus());

        } catch (IOException e) {

            throw new PolicyServiceException(
                    "Failed to write audit log",
                    e);
        }
    }

    @Override
    public void close() {
        closed = true;
    }
}