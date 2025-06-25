package project.semicolon.ecommercebackend.utils;

import project.semicolon.ecommercebackend.data.models.Cart;
import project.semicolon.ecommercebackend.data.models.CartItems;
import project.semicolon.ecommercebackend.data.models.Order;
import project.semicolon.ecommercebackend.dtos.Requests.CartRequest;
import project.semicolon.ecommercebackend.dtos.Requests.OrderRequest;
import project.semicolon.ecommercebackend.dtos.Responses.CartResponse;
import project.semicolon.ecommercebackend.dtos.Responses.OrderResponse;

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

    public static Order mapToOrder(OrderRequest request){
        Order order = new Order();
        order.setUserid(request.getUserId());
        order.setTotalPrice(request.getPrice());
        order.setItems(request.getItems());
        return order;
    }

    public static OrderResponse mapToOrderResponse(Order order){
        OrderResponse response = new OrderResponse();
        response.setUserId(order.getUserid());
        response.setOrderId(order.getOrderId());
        response.setCreatedAt(order.getCreatedAt());
        response.setDeliveryAddress(order.getDeliveryAddress());
        response.setTotalPrice(order.getTotalPrice());
        response.setItems(order.getItems());
        return response;
    }
}