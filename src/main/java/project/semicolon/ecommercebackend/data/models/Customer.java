package project.semicolon.ecommercebackend.data.models;
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


}
