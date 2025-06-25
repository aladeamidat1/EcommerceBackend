package project.semicolon.ecommercebackend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document("Order")
public class Order {
    @Id
    private String orderId;
    private String userid;
    private List<OrderItems> items;
    private double totalPrice;
    private String status;
    private String deliveryAddress;
    private LocalDateTime createdAt;
}
