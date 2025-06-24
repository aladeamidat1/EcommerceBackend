package project.semicolon.ecommercebackend.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.semicolon.ecommercebackend.Enums.Role;
import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void testThatUserCanRegister(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("John");
        registerRequest.setLastName("Doe");
        registerRequest.setEmail("johndoe@gmail");
        registerRequest.setPassword("password123");
        registerRequest.setPhoneNumber("1234567890");
        registerRequest.setRole(Role.CUSTOMER);

        RegisterResponse response = userService.register(registerRequest);
        assertEquals("User registered successfully", response.getMessage());

    }

}