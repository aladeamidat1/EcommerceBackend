package project.semicolon.ecommercebackend.utils;

import project.semicolon.ecommercebackend.data.models.Cart;
import project.semicolon.ecommercebackend.data.models.CartItems;
import project.semicolon.ecommercebackend.dtos.Requests.CartRequest;
import project.semicolon.ecommercebackend.dtos.Responses.CartResponse;

public class Mapper {

    public static CartItems mapToCartItems(CartRequest request) {
        CartItems items = new CartItems();
        items.setProductId(request.getProductId());
        items.setName(request.getName());
        items.setQuantity(request.getQuantity());
        items.setPrice(request.getPrice());
        return items;
    }


    public static CartResponse mapToAddCartResponse(Cart cart) {
        CartResponse response = new CartResponse();
        response.setUserId(cart.getUserId());
        response.setItems(cart.getItems());
        response.setTotalPrice(cart.getTotalPrice());
        return response;
    }

}
