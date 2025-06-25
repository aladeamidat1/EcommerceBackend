package project.semicolon.ecommercebackend.Service;

import project.semicolon.ecommercebackend.data.models.Seller;

import java.util.List;

public interface SellerService {
    Seller getSellerByEmail(String email);
    void updateProfile(String email, String firstName, String lastName);
    void addProduct(String sellerEmail, String productId);
    List<String> viewProducts(String sellerEmail);
    List<String> viewOrders(String sellerEmail);
}