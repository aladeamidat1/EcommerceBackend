package project.semicolon.ecommercebackend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String role; // e.g., "customer", "admin"
    private String address;
    private String phoneNumber;

    // Additional fields can be added as needed
}
