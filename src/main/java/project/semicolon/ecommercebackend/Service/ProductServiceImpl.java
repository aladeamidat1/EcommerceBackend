package project.semicolon.ecommercebackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.semicolon.ecommercebackend.data.models.Product;
import project.semicolon.ecommercebackend.data.repository.ProductRepository;
import project.semicolon.ecommercebackend.dtos.Responses.CreateProductResponse;
import project.semicolon.ecommercebackend.utils.ProductMapper;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
    private ProductRepository productRepository;


    @Override
    public CreateProductResponse createProduct(ProductRequest request) {
        Product product = ProductMapper.toProduct(request);
        Product savedProduct = productRepository.save(product);

        CreateProductResponse response = new CreateProductResponse();
        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setMessage("Product created successfully");
        return response;
    }


    @Override
    public CreateProductResponse getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CreateProductResponse response = new CreateProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setMessage("Product retrieved successfully");
        return response;
    }

    @Override
    public CreateProductResponse updateProduct(String id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCategory(project.semicolon.ecommercebackend.Enums.Category.valueOf(request.getCategory().toUpperCase()));
        Product updatedProduct = productRepository.save(product);

        CreateProductResponse response = new CreateProductResponse();
        response.setId(updatedProduct.getId());
        response.setName(updatedProduct.getName());
        response.setMessage("Product updated successfully");
        return response;
    }


    @Override
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<CreateProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(product -> {
            CreateProductResponse response = new CreateProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setMessage("Product retrieved successfully");
            return response;
        }).toList();
    }

    @Override
    public List<CreateProductResponse> getProductsByCategory(String category) {
        var cat = project.semicolon.ecommercebackend.Enums.Category.valueOf(category.toUpperCase());
        return productRepository.findAll().stream()
                .filter(product -> product.getCategory() == cat)
                .map(product -> {
                    CreateProductResponse response = new CreateProductResponse();
                    response.setId(product.getId());
                    response.setName(product.getName());
                    response.setMessage("Product retrieved successfully");
                    return response;
                })
                .toList();
    }
}