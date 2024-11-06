package com.aventon.platform.u202014511.crm.interfaces.rest.transform;

import com.aventon.platform.u202014511.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202014511.crm.interfaces.rest.resources.RatingResource;

/**
 * Assembler class to convert a Rating entity to a RatingResource.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public class RatingResourceFromEntityAssembler {

    /**
     * Converts a Rating entity to a RatingResource.
     * @param entity the {@link Rating} entity to convert
     * @return the {@link RatingResource} created
     */
    public static RatingResource toResourceFromEntity(Rating entity) {
        return new RatingResource(
                entity.getId(),
                entity.getProductId(),
                entity.getUserEmailAddress(),
                entity.getRating(),
                entity.getRatingAspect().name(),
                entity.getComment(),
                entity.getRatedAt()
        );
    }
}
