package project.semicolon.ecommercebackend.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.semicolon.ecommercebackend.Enums.Role;
import project.semicolon.ecommercebackend.data.models.Seller;
import project.semicolon.ecommercebackend.data.repository.SellerRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SellerServiceImplTest {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SellerRepository sellerRepository;

    @BeforeEach
    void setUp() {
        sellerRepository.deleteAll();
        Seller seller = new Seller();
        seller.setFirstName("Jane");
        seller.setLastName("Smith");
        seller.setEmail("seller@example.com");
        seller.setPassword("password");
        seller.setRole(Role.SELLER);
        sellerRepository.save(seller);
    }

    @Test
    void testUpdateProfile() {
        sellerService.updateProfile("seller@example.com", "Janet", "Doe");
        Seller updated = sellerService.getSellerByEmail("seller@example.com");
        assertEquals("Janet", updated.getFirstName());
        assertEquals("Doe", updated.getLastName());
    }

    @Test
    void testAddAndViewProducts() {
        sellerService.addProduct("seller@example.com", "prod1");
        sellerService.addProduct("seller@example.com", "prod2");
        List<String> products = sellerService.viewProducts("seller@example.com");
        assertTrue(products.contains("prod1"));
        assertTrue(products.contains("prod2"));
    }

    @Test
    void testViewOrders() {
        Seller seller = sellerService.getSellerByEmail("seller@example.com");
        seller.setOrderIds(List.of("order1", "order2"));
        sellerRepository.save(seller);

        List<String> orders = sellerService.viewOrders("seller@example.com");
        assertTrue(orders.contains("order1"));
        assertTrue(orders.contains("order2"));
    }
}