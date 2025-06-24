package project.semicolon.ecommercebackend.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Order Items")
public class OrderItems {
    private String productId;
    private String name;
    private int quantity;
    private double price;
}
