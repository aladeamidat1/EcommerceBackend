//package project.semicolon.ecommercebackend.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import project.semicolon.ecommercebackend.data.models.Order;
//import project.semicolon.ecommercebackend.data.repository.OrderRepository;
//import project.semicolon.ecommercebackend.dtos.Requests.OrderRequest;
//import project.semicolon.ecommercebackend.dtos.Responses.OrderResponse;
//import project.semicolon.ecommercebackend.utils.UserMapper;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@Service
//public class OrderServiceImpl implements OrderService {
//
//    @Autowired
//    OrderRepository orderRepository;
//
//    @Override
//    public OrderResponse placeOrder(OrderRequest request) {
//        Order order = UserMapper.mapToOrder(request);
//        order.setStatus("Pending");
//        order.setCreatedAt(LocalDateTime.now());
//
//        double total = order.getItems().stream()
//                .mapToDouble(item -> item.getPrice() * item.getQuantity())
//                .sum();
//        order.setTotalPrice(total);
//        Order savedOrder = orderRepository.save(order);
//        return UserMapper.mapToOrderResponse(savedOrder);
//    }
//
//    @Override
//    public OrderResponse findOrderById(String userId) {
//        Optional<Order> optOrder = orderRepository.findById(userId);
//        return optOrder.map(UserMapper::mapToOrderResponse)
//                .orElseThrow(() -> new RuntimeException("Order not found for user: " + userId));
//    }
//
//}
