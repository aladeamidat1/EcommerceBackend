package project.semicolon.ecommercebackend.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.semicolon.ecommercebackend.Enums.Role;
import project.semicolon.ecommercebackend.Exceptions.EmailAlreadyExistException;
import project.semicolon.ecommercebackend.Exceptions.InvalidEmailException;
import project.semicolon.ecommercebackend.dtos.Requests.LoginRequest;
import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.LoginResponse;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;

import static org.junit.jupiter.api.Assertions.*;
import static project.semicolon.ecommercebackend.Enums.Role.SELLER;

@SpringBootTest

class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void testThatUserCanRegister() throws InvalidEmailException, EmailAlreadyExistException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("Johnd11");
        registerRequest.setLastName("Doed1");
        registerRequest.setEmail("johndo1ed@gmail");
        registerRequest.setPassword("password123");
        registerRequest.setPhoneNumber("09014465194");
        registerRequest.setRole(SELLER);
        RegisterResponse response = userService.register(registerRequest);
        assertEquals("User registered successfully", response.getMessage());
    }

    @Test
    public void testThatUserCannotRegisterWithDuplicateEmail() throws InvalidEmailException, EmailAlreadyExistException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("John");
        registerRequest.setLastName("Doe");
        registerRequest.setEmail("johndoe@gmail");
        registerRequest.setPassword("password123");
        registerRequest.setPhoneNumber("1234567891");
        registerRequest.setRole(Role.CUSTOMER);

        userService.register(registerRequest);

        RegisterRequest duplicateRequest = new RegisterRequest();
        duplicateRequest.setFirstName("Janet");
        duplicateRequest.setLastName("Smith");
        duplicateRequest.setEmail("janedoe@gmail.com");
        duplicateRequest.setPassword("password123");
        duplicateRequest.setPhoneNumber("1234567892");
        duplicateRequest.setRole(Role.CUSTOMER);


        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.register(duplicateRequest);
        });
        assertTrue(exception.getMessage().contains("Email already exists"));


    }

    @Test
    public void testThatUserCanLogin() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("Alice");
        registerRequest.setLastName("Wonderland");
        registerRequest.setEmail("alice@gmail.com");
        registerRequest.setPassword("alicepass");
        registerRequest.setPhoneNumber("1234567893");
        registerRequest.setRole(SELLER);

//        userService.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("alice@gmail.com");
        loginRequest.setPassword("alicepass");

        LoginResponse response = userService.login(loginRequest);
        assertEquals("Login successful", response.getMessage());
        assertEquals("CUSTOMER", response.getRole());
    }
//
//    @Test
//    void testThatLoginWithInvalidPasswordThrows() {
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setFirstName("Bob");
//        registerRequest.setLastName("Builder");
//        registerRequest.setEmail("bob@gmail.com");
//        registerRequest.setPassword("bobpass");
//        registerRequest.setPhoneNumber("1234567894");
//        registerRequest.setRole(Role.CUSTOMER);
//
////        userService.register(registerRequest);
//
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setEmail("bob@gmail.com");
//        loginRequest.setPassword("wrongpass");
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
//            userService.login(loginRequest);
//        });
//        assertEquals("Invalid password", exception.getMessage());
//    }
//



}