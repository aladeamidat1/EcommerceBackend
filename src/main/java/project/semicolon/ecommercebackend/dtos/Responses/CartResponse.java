package project.semicolon.ecommercebackend.dtos.Responses;

import lombok.Data;
import project.semicolon.ecommercebackend.data.models.CartItems;

import java.util.List;

@Data
public class CartResponse {
    private String userId;
    private List<CartItems> items;
    private double totalPrice;
    private String productId;
}
