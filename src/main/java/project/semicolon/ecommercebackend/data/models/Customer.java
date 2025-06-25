package project.semicolon.ecommercebackend.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Customer {
    @Id
    private String id;
    private String firstName;;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String Address;
    private LocalDateTime createdAt;
}
