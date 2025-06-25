package project.semicolon.ecommercebackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import project.semicolon.ecommercebackend.data.models.Order;
import project.semicolon.ecommercebackend.data.models.OrderItems;
import project.semicolon.ecommercebackend.data.repository.OrderRepository;
import project.semicolon.ecommercebackend.dtos.Requests.OrderRequest;
import project.semicolon.ecommercebackend.dtos.Responses.OrderResponse;
import project.semicolon.ecommercebackend.utils.Mapper;

import java.time.LocalDateTime;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        Order order = Mapper.mapToOrder(request);
        order.setStatus("Pending");
        order.setCreatedAt(LocalDateTime.now());

        double total = order.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        order.setTotalPrice(total);
        Order savedOrder = orderRepository.save(order);
        return Mapper.mapToOrderResponse(savedOrder);
    }


    @Override
    public OrderResponse findOrderById(String userId) {
        List<OrderItems> order = orderRepository.findById(userId);

    }
}
