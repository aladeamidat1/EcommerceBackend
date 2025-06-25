package project.semicolon.ecommercebackend.dtos.Requests;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;

}
