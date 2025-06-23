package project.semicolon.ecommercebackend.dtos.Requests;

import lombok.Getter;
import lombok.Setter;
import project.semicolon.ecommercebackend.Enums.Role;

@Getter
@Setter

public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;

}
