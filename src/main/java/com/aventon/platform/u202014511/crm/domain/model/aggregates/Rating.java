package com.aventon.platform.u202014511.crm.domain.model.aggregates;

import com.aventon.platform.u202014511.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.EmailAddress;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202014511.crm.domain.model.valueobjects.RatingAspect;
import com.aventon.platform.u202014511.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

/**
 * Rating
 * @summary
 * This class represents the Rating aggregate root entity.
 * It contains the rating information of a product.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
@Entity
public class Rating extends AuditableAbstractAggregateRoot<Rating> {

    @Embedded
    private ProductId productId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    private EmailAddress userEmailAddress;

    @Getter
    @Min(1)
    @Max(5)
    @NotNull
    private Integer rating;

    @Getter
    @NotNull
    private RatingAspect ratingAspect;

    @Getter
    @NotNull
    @Size(max = 360)
    private String comment;

    @Getter
    private Date ratedAt;

    protected Rating() {}

    /**
     * Create a new Rating.
     * @param command The command to create a new Rating.
     * @see CreateRatingCommand
     * @see ProductId
     * @see EmailAddress
     * @see RatingAspect
     * @since 1.0
     */
    public Rating(CreateRatingCommand command) {
        this.productId = new ProductId(command.productId());
        this.userEmailAddress = new EmailAddress(command.userEmailAddress());
        this.rating = command.rating();
        this.ratingAspect = RatingAspect.valueOf(command.ratingAspect());
        this.comment = command.comment();
        this.ratedAt = new Date();
    }

    public Long getProductId() {
        return productId.productId();
    }

    public String getUserEmailAddress() {
        return userEmailAddress.address();
    }
}
