package project.semicolon.ecommercebackend.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Cart")
public class Cart {
    private String userId;
    private List<CartItems> items;
    private double totalPrice;
}
