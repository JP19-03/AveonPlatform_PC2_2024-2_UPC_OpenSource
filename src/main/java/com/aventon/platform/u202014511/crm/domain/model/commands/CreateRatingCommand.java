package com.aventon.platform.u202014511.crm.domain.model.commands;

/**
 * Command to create a new rating.
 * @param productId The product id
 * @param userEmailAddress The user email address
 * @param rating The rating
 * @param ratingAspect The rating aspect
 * @param comment The comment
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public record CreateRatingCommand(
        Long productId,
        String userEmailAddress,
        Integer rating,
        String ratingAspect,
        String comment
) {
    public CreateRatingCommand {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }
}
