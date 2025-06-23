package project.semicolon.ecommercebackend.dtos.Responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginResponse {
    private String message;
    private String token;
    private String role;

}
