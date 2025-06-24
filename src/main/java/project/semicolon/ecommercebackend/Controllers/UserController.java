package project.semicolon.ecommercebackend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.semicolon.ecommercebackend.Exceptions.InvalidEmailException;
import project.semicolon.ecommercebackend.Service.UserService;
import project.semicolon.ecommercebackend.dtos.Requests.LoginRequest;
import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.LoginResponse;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest)
            throws InvalidEmailException {
        return userService.register(registerRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }


    @PostMapping("/logout")
    public void logout(@RequestParam String email){
        userService.logout(email);
    }
}
