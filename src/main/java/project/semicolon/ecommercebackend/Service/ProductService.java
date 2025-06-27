package project.semicolon.ecommercebackend.Service;

import project.semicolon.ecommercebackend.dtos.Requests.ProductRequest;
import project.semicolon.ecommercebackend.dtos.Responses.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    ProductResponse getProductById(String id);
    ProductResponse updateProduct(String id, ProductRequest request);
    void deleteProduct(String id);
    List<ProductResponse> getAllProducts();
    List<ProductResponse> getProductsByCategory(String category);

}
