package project.semicolon.ecommercebackend.data.models;

<<<<<<< HEAD
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
=======
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "customers")
public class Customer extends User {
    private String address;
    private List<String> orderIds;
    private String cartId;


>>>>>>> origin/main
}
