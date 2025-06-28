package project.semicolon.ecommercebackend.dtos.Responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateProductResponse {
    private String id;
    private String name;
    private String message;
    private String imageUrl;
    private String description;
    private double price;
    private String category;
    private int Quantity;
}
