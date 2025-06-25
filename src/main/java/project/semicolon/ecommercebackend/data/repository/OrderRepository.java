package project.semicolon.ecommercebackend.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.semicolon.ecommercebackend.data.models.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
}
