package project.semicolon.ecommercebackend.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.semicolon.ecommercebackend.data.models.CartItem;

public interface CartItemRepository extends MongoRepository<CartItem, String> {

}
