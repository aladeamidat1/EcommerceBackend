package project.semicolon.ecommercebackend.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.semicolon.ecommercebackend.data.models.User;


import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findUsersByEmail(String email);

    Optional<User> findByPhoneNumber(String phoneNumber);
}
