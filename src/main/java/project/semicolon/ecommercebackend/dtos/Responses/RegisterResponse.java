package project.semicolon.ecommercebackend.dtos.Responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter

public class RegisterResponse {
    private String message;
    private String role;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Id
    private String Id;


}
