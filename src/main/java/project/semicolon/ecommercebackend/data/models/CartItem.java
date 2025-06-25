package project.semicolon.ecommercebackend.data.models;


import lombok.Data;

@Data
public class CartItem {
    private String productId;
    private String name;
    private int quantity;
    private double price;

}
