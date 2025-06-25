package project.semicolon.ecommercebackend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.semicolon.ecommercebackend.dtos.Requests.CartRequest;
import project.semicolon.ecommercebackend.dtos.Responses.CartResponse;
import project.semicolon.ecommercebackend.Service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CartResponse addToCart(@RequestBody CartRequest request) {
        return cartService.addToCart(request);
    }

    @DeleteMapping("/remove")
    public CartResponse removeFromCart(@RequestParam String userId, @RequestParam String productId) {
        return cartService.removeFromCart(userId, productId);
    }

    @DeleteMapping("/clear")
    public void clearCart(@RequestParam String userId) {
        cartService.clearCart(userId);
    }

    @GetMapping
    public CartResponse getCart(@RequestParam String userId) {
        throw new UnsupportedOperationException("Implement getCart in CartService if needed.");
    }
}