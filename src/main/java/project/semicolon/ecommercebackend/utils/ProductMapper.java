package project.semicolon.ecommercebackend.utils;

import project.semicolon.ecommercebackend.data.models.Product;
import project.semicolon.ecommercebackend.Enums.Category;
import project.semicolon.ecommercebackend.dtos.Requests.CreateProductRequest;
import project.semicolon.ecommercebackend.dtos.Responses.CreateProductResponse;

public class ProductMapper {
    public static Product toProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCategory(Category.valueOf(request.getCategory().toUpperCase()));
        product.setImageUrl(request.getImageUrl());
        return product;
    }

    public static CreateProductResponse toResponse(Product product) {
        CreateProductResponse response = new CreateProductResponse();
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setQuantity(product.getQuantity());
        response.setCategory(product.getCategory().name());
        response.setImageUrl(product.getImageUrl());
        return response;
    }
}