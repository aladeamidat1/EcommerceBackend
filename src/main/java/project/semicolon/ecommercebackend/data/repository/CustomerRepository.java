package project.semicolon.ecommercebackend.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.semicolon.ecommercebackend.data.models.Customer;

import java.util.Optional;


public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
}

