package project.semicolon.ecommercebackend.dtos.Responses;

import lombok.Getter;
import lombok.Setter;
import project.semicolon.ecommercebackend.Enums.Role;

@Getter
@Setter

public class LoginResponse {
    private String message;
    private String token;
    private String role;



}
