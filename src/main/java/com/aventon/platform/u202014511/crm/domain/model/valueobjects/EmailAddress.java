package com.aventon.platform.u202014511.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * UserEmailAddress
 * @param address the email address
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
@Embeddable
public record EmailAddress(@Email @Size(max = 50) String address) {

    public EmailAddress {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Email address must not be null or empty");
        }
    }

    /**
     * Default constructor
     */
    public EmailAddress() {
        this(null);
    }
}