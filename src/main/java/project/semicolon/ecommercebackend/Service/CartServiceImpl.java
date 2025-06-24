package project.semicolon.ecommercebackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.semicolon.ecommercebackend.data.models.Cart;
import project.semicolon.ecommercebackend.data.models.CartItems;
import project.semicolon.ecommercebackend.data.repository.CartRepository;
import project.semicolon.ecommercebackend.dtos.Requests.CartRequest;
import project.semicolon.ecommercebackend.dtos.Responses.CartResponse;
import project.semicolon.ecommercebackend.utils.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartResponse addToCart(CartRequest request) {
        Optional<Cart> OptCart = cartRepository.findById(request.getUserId());
        Cart cart = OptCart.orElse(new Cart(request.getUserId(), new ArrayList<>()));

        CartItems items = Mapper.mapToCartItems(request);
        addCartItem(cart, items);

        Cart savedCart = cartRepository.save(cart);
        return Mapper.mapToAddCartResponse(savedCart);
    }


    @Override
    public CartResponse removeFromCart(String userId, String productId) {
        Cart cart = cartRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));

        List<CartItems> items = cart.getItems();
        items.removeIf(item -> item.getProductId().equals(productId));

        Cart updateCart = cartRepository.save(cart);
        return Mapper.mapToAddCartResponse(updateCart);
    }

    @Override
    public void clearCart(String userId) {
        Cart cart = cartRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("cart not found user" + userId));

        cart.setItems(new ArrayList<>());
        cartRepository.save(cart);
    }

    private void addCartItem(Cart cart, CartItems newItem){
        boolean itemsIsEmpty = cart.getItems() == null;

        if(itemsIsEmpty) cart.setItems(new ArrayList<>());
        List<CartItems> items = cart.getItems();

        for(CartItems item : items){
            boolean checkIfItAlreadyExist = item.getProductId().equals(newItem.getProductId());
           if(checkIfItAlreadyExist) item.setQuality(item.getQuality() + newItem.getQuality());
        }
    }
}
