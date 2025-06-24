package project.semicolon.ecommercebackend.Service;


import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);
}
