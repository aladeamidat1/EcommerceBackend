package project.semicolon.ecommercebackend.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("Order")
public class Order {
    @Id
    private String id;
    private String userid;
    private List<OrderItems> items;
    private double totalPrice;
    private String status;
    private String deliveryAddress;
    private LocalDateTime createdAt;
}
