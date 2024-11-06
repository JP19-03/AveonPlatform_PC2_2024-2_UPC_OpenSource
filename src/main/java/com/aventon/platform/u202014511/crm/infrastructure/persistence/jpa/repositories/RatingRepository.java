package com.aventon.platform.u202014511.crm.infrastructure.persistence.jpa.repositories;

import com.aventon.platform.u202014511.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.EmailAddress;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.RatingAspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Rating repository.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    /**
     * Check if a rating exists by user email address, product id and rating aspect.
     * @param userEmailAddress the user email address of the rating.
     * @param productId the product id of the rating.
     * @param ratingAspect the rating aspect of the rating.
     * @return true if a rating exists, false otherwise.
     */
    boolean existsByUserEmailAddressAndProductIdAndRatingAspect(EmailAddress userEmailAddress,
                                                                ProductId productId,
                                                                RatingAspect ratingAspect);
}
