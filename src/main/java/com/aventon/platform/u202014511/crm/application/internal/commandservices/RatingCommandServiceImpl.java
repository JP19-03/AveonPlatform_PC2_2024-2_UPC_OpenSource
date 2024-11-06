package com.aventon.platform.u202014511.crm.application.internal.commandservices;

import com.aventon.platform.u202014511.crm.domain.exceptions.DuplicateRatingException;
import com.aventon.platform.u202014511.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202014511.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.EmailAddress;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.RatingAspect;
import com.aventon.platform.u202014511.crm.domain.services.RatingCommandService;
import com.aventon.platform.u202014511.crm.infrastructure.persistence.jpa.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the RatingCommandService interface
 * @summary
 * This class is responsible for handling the command to create a rating
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
@Service
public class RatingCommandServiceImpl implements RatingCommandService {
    private final RatingRepository ratingRepository;

    public RatingCommandServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    /** inherited doc */
    @Override
    public Optional<Rating> handle(CreateRatingCommand command) {
        var emailAddress = new EmailAddress(command.userEmailAddress());
        var productId = new ProductId(command.productId());

        if (ratingRepository.existsByUserEmailAddressAndProductIdAndRatingAspect
                (emailAddress, productId, RatingAspect.valueOf(command.ratingAspect()))) {
            throw new DuplicateRatingException(command.productId(), command.userEmailAddress(), RatingAspect.valueOf(command.ratingAspect()));
        }
        var rating = new Rating(command);
        ratingRepository.save(rating);
        return Optional.of(rating);
    }
}
