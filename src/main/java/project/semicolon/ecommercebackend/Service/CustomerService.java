package project.semicolon.ecommercebackend.Service;

import project.semicolon.ecommercebackend.data.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerByEmail(String email);
    void updateAddress(String email, String newAddress);
    void addToCart(String customerEmail, String productId);
    void removeFromCart(String customerEmail, String productId);
    List<String> viewCart(String customerEmail);
    void placeOrder(String customerEmail);
    List<String> viewOrders(String customerEmail);

}
