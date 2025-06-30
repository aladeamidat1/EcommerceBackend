package project.semicolon.ecommercebackend.Service;

import project.semicolon.ecommercebackend.data.repository.UserRepository;
import project.semicolon.ecommercebackend.dtos.Requests.AdminLoginRequest;
import project.semicolon.ecommercebackend.dtos.Responses.AdminLoginResponse;
import project.semicolon.ecommercebackend.dtos.Responses.OrderResponse;
import project.semicolon.ecommercebackend.dtos.Responses.ProductResponse;

import java.util.List;

public interface AdminService {
    AdminLoginResponse login(AdminLoginRequest request);
    List<UserRepository> getAllUsers();
    void deleteUserByEmail(String email);
    void deleteUserById(String userId);
    List<ProductResponse> viewAllProducts();
    void deleteProductById(String productId);
    List<OrderResponse> viewAllOrders();

}
