package project.semicolon.ecommercebackend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import project.semicolon.ecommercebackend.Enums.Category;

@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Category category;
    private String imageUrl;
}
