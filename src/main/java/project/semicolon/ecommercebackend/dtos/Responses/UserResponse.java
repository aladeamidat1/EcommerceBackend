package project.semicolon.ecommercebackend.dtos.Responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import project.semicolon.ecommercebackend.Enums.Role;

@Getter
@Setter
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    @Id
    private String id;
    private Role role;
}
