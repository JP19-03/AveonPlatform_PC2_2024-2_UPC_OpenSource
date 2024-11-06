package com.aventon.platform.u202014511.crm.domain.services;

import com.aventon.platform.u202014511.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202014511.crm.domain.model.commands.CreateRatingCommand;

import java.util.Optional;

/**
 * This interface represents the service that handles the commands related to the {@link Rating} aggregate.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public interface RatingCommandService {

    /**
     * Handles the command to create a new rating.
     * @param command The command to create a new rating containing the necessary data.
     * @return An optional containing the created rating if the operation was successful, an empty optional otherwise.
     */
    Optional<Rating> handle(CreateRatingCommand command);
}
