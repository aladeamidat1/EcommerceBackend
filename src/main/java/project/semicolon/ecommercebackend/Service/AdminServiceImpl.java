package project.semicolon.ecommercebackend.Service;

import project.semicolon.ecommercebackend.data.repository.UserRepository;
import project.semicolon.ecommercebackend.dtos.Requests.AdminLoginRequest;
import project.semicolon.ecommercebackend.dtos.Responses.AdminLoginResponse;
import project.semicolon.ecommercebackend.dtos.Responses.OrderResponse;
import project.semicolon.ecommercebackend.dtos.Responses.ProductResponse;

import java.util.List;

public class AdminServiceImpl implements AdminService{
    @Override
    public AdminLoginResponse login(AdminLoginRequest request) {

    }

    @Override
    public List<UserRepository> getAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUserByEmail(String email) {

    }

    @Override
    public void deleteUserById(String userId) {

    }

    @Override
    public List<ProductResponse> viewAllProducts() {
        return List.of();
    }

    @Override
    public void deleteProductById(String productId) {

    }

    @Override
    public List<OrderResponse> viewAllOrders() {
        return List.of();
    }
}
