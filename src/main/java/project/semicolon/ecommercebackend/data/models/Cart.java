package project.semicolon.ecommercebackend.data.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Cart")
public class Cart {
    private String userId;
    private List<CartItem> items;
    private double totalPrice;
}
