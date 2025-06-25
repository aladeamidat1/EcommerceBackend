package project.semicolon.ecommercebackend.dtos.Requests;

import lombok.Data;
import project.semicolon.ecommercebackend.data.models.OrderItems;

import java.util.List;

@Data
public class OrderRequest {
    private String userId;
    private List<OrderItems> items;
    private double price;

}
