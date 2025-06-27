package project.semicolon.ecommercebackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.semicolon.ecommercebackend.data.models.Cart;
import project.semicolon.ecommercebackend.data.models.CartItem;
import project.semicolon.ecommercebackend.data.repository.CartRepository;
import project.semicolon.ecommercebackend.dtos.Requests.CartRequest;
import project.semicolon.ecommercebackend.dtos.Responses.CartResponse;
import project.semicolon.ecommercebackend.utils.CartMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartResponse addToCart(CartRequest request) {
        Optional<Cart> optCart = cartRepository.findById(request.getUserId());
        Cart cart = optCart.orElse(new Cart(request.getUserId(), new ArrayList<>(), 0.0));

        CartItem item = CartMapper.mapToCartItems(request);
        addCartItem(cart, item);

        updateTotalPrice(cart);
        Cart savedCart = cartRepository.save(cart);
        return CartMapper.mapToAddCartResponse(savedCart);
    }

    @Override
    public CartResponse removeFromCart(String userId, String productId) {
        Cart cart = cartRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));

        List<CartItem> items = cart.getItems();
        items.removeIf(item -> item.getProductId().equals(productId));

        updateTotalPrice(cart);
        Cart updatedCart = cartRepository.save(cart);
        return CartMapper.mapToAddCartResponse(updatedCart);
    }

    @Override
    public void clearCart(String userId) {
        Cart cart = cartRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("cart not found user" + userId));

        cart.setItems(new ArrayList<>());
        cart.setTotalPrice(0.0);
        cartRepository.save(cart);
    }

    private void updateTotalPrice(Cart cart) {
        double total = cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(total);
    }

    private void addCartItem(Cart cart, CartItem newItem) {
        if (cart.getItems() == null) {
            cart.setItems(new ArrayList<>());
        }

        List<CartItem> items = cart.getItems();
        boolean itemExists = false;

        for (CartItem item : items) {
            if (item.getProductId().equals(newItem.getProductId())) {
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            items.add(newItem);
        }
    }
}