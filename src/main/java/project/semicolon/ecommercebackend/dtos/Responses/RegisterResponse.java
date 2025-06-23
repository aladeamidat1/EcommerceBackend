package project.semicolon.ecommercebackend.dtos.Responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegisterResponse {
    private String message;
    private String role;
    private String email;
    private String fullName;


}
