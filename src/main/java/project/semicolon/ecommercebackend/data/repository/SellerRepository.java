package project.semicolon.ecommercebackend.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.semicolon.ecommercebackend.data.models.Seller;

public interface SellerRepository extends MongoRepository<Seller, String> {

}
