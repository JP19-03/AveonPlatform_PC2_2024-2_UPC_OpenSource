package com.aventon.platform.u202014511.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * ProductId value object
 * @param productId Product id
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
@Embeddable
public record ProductId(Long productId) {

    public ProductId {
        if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("Product id must not be null or less than zero");
        }
    }

    /**
     * Default constructor for ProductId
     */
    public ProductId() { this(0L); }
}
