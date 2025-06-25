package project.semicolon.ecommercebackend.dtos.Responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import project.semicolon.ecommercebackend.data.models.CartItem;

import java.util.List;

@Getter
@Setter
public class CartResponse {
    private String userId;
    private List<CartItem> items;
    private double totalPrice;
    private String productId;
}
