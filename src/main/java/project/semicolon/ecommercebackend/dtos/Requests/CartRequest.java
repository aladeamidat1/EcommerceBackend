package project.semicolon.ecommercebackend.dtos.Requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CartRequest {
    private String userId;
    private String productId;
    private String name;
    private int quantity;
    private double price;

}