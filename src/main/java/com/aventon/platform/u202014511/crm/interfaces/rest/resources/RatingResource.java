package com.aventon.platform.u202014511.crm.interfaces.rest.resources;

import java.util.Date;

/**
 * RatingResource
 * @param id the rating id
 * @param productId the product id
 * @param userEmailAddress the user email address
 * @param rating the rating
 * @param ratingAspect the rating aspect
 * @param comment the comment
 * @param ratedAt the rated at date
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public record RatingResource(
        Long id,
        Long productId,
        String userEmailAddress,
        Integer rating,
        String ratingAspect,
        String comment,
        Date ratedAt
) {
}
