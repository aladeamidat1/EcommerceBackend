package project.semicolon.ecommercebackend.dtos.Requests;

import lombok.Data;

@Data
public class CartRequest {
    private String userId;
    private String productId;
    private String name;
    private int quantity;
    private double price;

}