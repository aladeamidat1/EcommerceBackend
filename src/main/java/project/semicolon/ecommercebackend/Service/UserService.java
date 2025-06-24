package project.semicolon.ecommercebackend.Service;


import project.semicolon.ecommercebackend.dtos.Requests.LoginRequest;
import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.LoginResponse;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);

    void logout(String email);
}
