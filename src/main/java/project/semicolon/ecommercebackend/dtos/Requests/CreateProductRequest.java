package project.semicolon.ecommercebackend.dtos.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateProductRequest {
    @NotBlank(message = "This field is required")
    private String productName;

    @NotBlank(message = "This field is required")
    private String description;

    @NotNull(message = "This field is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "This field is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

    @NotBlank(message = "This field is required")
    private String category;

    @NotBlank(message = "This field is required")
    private String imageUrl;


}