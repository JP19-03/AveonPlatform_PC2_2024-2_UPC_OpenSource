package com.aventon.platform.u202014511.crm.interfaces.rest.transform;

import com.aventon.platform.u202014511.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.u202014511.crm.interfaces.rest.resources.CreateRatingResource;

/**
 * Assembler class to convert a CreateRatingResource to a CreateRatingCommand.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public class CreateRatingCommandFromResourceAssembler {

    /**
     * Converts a CreateRatingResource to a CreateRatingCommand.
     * @param resource the {@link CreateRatingResource} resource to convert
     * @param productId the product id
     * @return the {@link CreateRatingCommand} command
     */
    public static CreateRatingCommand toCommandFromResource(CreateRatingResource resource, Long productId) {
        return new CreateRatingCommand(
                productId,
                resource.userEmailAddress(),
                resource.rating(),
                resource.ratingAspect(),
                resource.comment()
        );
    }
}
