package project.semicolon.ecommercebackend.utils;

import project.semicolon.ecommercebackend.Enums.Role;
import project.semicolon.ecommercebackend.Exceptions.InvalidEmailException;
import project.semicolon.ecommercebackend.data.models.Customer;
import project.semicolon.ecommercebackend.data.models.Seller;
import project.semicolon.ecommercebackend.data.models.User;
import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Mapper {
    public static User RegisterRequestToUser(RegisterRequest registerRequest){
        isValidUser(RegisterRequest);

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setRole(registerRequest.getRole());
        return user;

    }

    public static RegisterResponse getRegisterResponse(User savedUser){
        RegisterResponse response = new RegisterResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setPhoneNumber(savedUser.getPhoneNumber());
        response.setRole(Role.valueOf(savedUser.getRole().name()));
        return response;
    }

    private static void isValidUser(RegisterRequest registerRequest){
        validateEmail(RegisterRequest.getEmail());
        ValidatePhoneNumber(RegisterRequest.getPhoneNumber());
        ValidateFirstName(RegisterRequest.getFirstName());
        validateLastName(RegisterRequest.getLastName());
        ValidateRole(RegisterRequest.getRole());

    }
    private static void validateEmail(String email){
        if(email == null || email.trim().isEmpty()) throw new InvalidEmailException("Email can not empty")
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new InvalidEmailException("Invalid email format");
    }


}
