package project.semicolon.ecommercebackend.Service;

import project.semicolon.ecommercebackend.dtos.Requests.OrderRequest;
import project.semicolon.ecommercebackend.dtos.Responses.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest request);
    OrderResponse findOrderById(String userId);
}
