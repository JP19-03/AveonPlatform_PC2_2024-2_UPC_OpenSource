package com.aventon.platform.u202014511.crm.domain.exceptions;

import com.aventon.platform.u202014511.crm.domain.model.valueobjects.EmailAddress;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.RatingAspect;

/**
 * Exception thrown when a rating with the same product ID, email address and rating aspect already exists.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public class DuplicateRatingException extends RuntimeException{
    public DuplicateRatingException(Long productId, String emailAddress, RatingAspect ratingAspect) {
        super("Rating with product ID %s and email address %s and rating aspect %s already exists".formatted(productId, emailAddress, ratingAspect));
    }
}
