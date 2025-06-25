package project.semicolon.ecommercebackend.dtos.Responses;

import lombok.Data;
import project.semicolon.ecommercebackend.data.models.OrderItems;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private String userId;
    private String orderId;
    private List<OrderItems> items;
    private double totalPrice;
    private LocalDateTime createdAt;
    private String deliveryAddress;
}
