package com.aventon.platform.u202014511.crm.interfaces.rest;

import com.aventon.platform.u202014511.crm.domain.services.RatingCommandService;
import com.aventon.platform.u202014511.crm.interfaces.rest.resources.CreateRatingResource;
import com.aventon.platform.u202014511.crm.interfaces.rest.resources.RatingResource;
import com.aventon.platform.u202014511.crm.interfaces.rest.transform.CreateRatingCommandFromResourceAssembler;
import com.aventon.platform.u202014511.crm.interfaces.rest.transform.RatingResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for product ratings.
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
@RestController
@RequestMapping(value = "api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Product Ratings", description = "Endpoints for managing product ratings")
public class ProductRatingsController {

    private final RatingCommandService ratingCommandService;

    public ProductRatingsController(RatingCommandService ratingCommandService) {
        this.ratingCommandService = ratingCommandService;
    }

    /**
     * Add a rating to a product.
     * @param productId The product id to rate.
     * @param resource The {@link CreateRatingResource} with the rating data.
     * @return A {@link RatingResource} with the created rating data, or a bad request response if the rating could not be created.
     */
    @PostMapping(value = "/{productId}/ratings")
    @Operation(summary = "Add a rating to a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Profile created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<RatingResource> rateAProduct(@PathVariable Long productId,
                                                       @RequestBody CreateRatingResource resource) {
        var command = CreateRatingCommandFromResourceAssembler.toCommandFromResource(resource, productId);
        var rating = ratingCommandService.handle(command);
        if (rating.isEmpty()) return ResponseEntity.badRequest().build();
        var createdRating = rating.get();
        var ratingResource = RatingResourceFromEntityAssembler.toResourceFromEntity(createdRating);
        return ResponseEntity.ok(ratingResource);
    }
}
