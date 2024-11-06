package com.aventon.platform.u202014511.crm.interfaces.rest.resources;

/**
 * Resource to create a rating
 * @param userEmailAddress email address of the user
 * @param rating rating value
 * @param ratingAspect rating aspect
 * @param comment comment
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public record CreateRatingResource(
        String userEmailAddress,
        Integer rating,
        String ratingAspect,
        String comment
) {
}
