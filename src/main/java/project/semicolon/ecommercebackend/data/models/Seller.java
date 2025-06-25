package project.semicolon.ecommercebackend.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "sellers")
public class Seller extends User {
    private List<String> productIds;
    private List<String> orderIds;
}