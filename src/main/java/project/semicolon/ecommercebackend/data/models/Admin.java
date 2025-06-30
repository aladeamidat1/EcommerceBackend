package project.semicolon.ecommercebackend.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Admin")
public class Admin {
    @Id
    private String id;
    private String userId;

}
