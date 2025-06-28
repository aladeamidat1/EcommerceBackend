package project.semicolon.ecommercebackend.Service;

import project.semicolon.ecommercebackend.dtos.Responses.CreateProductResponse;

import java.util.List;

public interface ProductService {
    CreateProductResponse createProduct(ProductRequest request);
    CreateProductResponse getProductById(String id);
    CreateProductResponse updateProduct(String id, ProductRequest request);
    void deleteProduct(String id);
    List<CreateProductResponse> getAllProducts();
    List<CreateProductResponse> getProductsByCategory(String category);

}
