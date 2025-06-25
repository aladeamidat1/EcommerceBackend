package project.semicolon.ecommercebackend.Service;

import org.springframework.stereotype.Service;
import project.semicolon.ecommercebackend.dtos.Requests.CartRequest;
import project.semicolon.ecommercebackend.dtos.Responses.CartResponse;

@Service
public interface CartService {
    CartResponse addToCart(CartRequest request);
    CartResponse removeFromCart(String userId, String productId);
    void clearCart(String userId);
}
