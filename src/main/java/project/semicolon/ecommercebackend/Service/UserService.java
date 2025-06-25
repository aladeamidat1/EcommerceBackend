package project.semicolon.ecommercebackend.Service;


import project.semicolon.ecommercebackend.Exceptions.EmailAlreadyExistException;
import project.semicolon.ecommercebackend.Exceptions.InvalidEmailException;
import project.semicolon.ecommercebackend.dtos.Requests.LoginRequest;
import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.LoginResponse;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest) throws EmailAlreadyExistException, InvalidEmailException;

    LoginResponse login(LoginRequest loginRequest);

    void logout(String email);
}
