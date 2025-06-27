package project.semicolon.ecommercebackend.utils;

import project.semicolon.ecommercebackend.data.models.Product;
import project.semicolon.ecommercebackend.dtos.Requests.ProductRequest;
import project.semicolon.ecommercebackend.Enums.Category;

public class ProductMapper {
    public static Product toProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCategory(Category.valueOf(request.getCategory().toUpperCase()));
        return product;
    }
}