package project.semicolon.ecommercebackend.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.semicolon.ecommercebackend.Enums.Role;
import project.semicolon.ecommercebackend.data.models.Customer;
import project.semicolon.ecommercebackend.data.repository.CustomerRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        Customer customer = new Customer();
        customer.setFirstName("Test");
        customer.setLastName("User");
        customer.setEmail("test@example.com");
        customer.setPassword("pass");
        customer.setRole(Role.CUSTOMER);
        customer.setAddress("Old Address");
        customerRepository.save(customer);
    }

    @Test
    void testUpdateAddress() {
        customerService.updateAddress("test@example.com", "New Address");
        Customer updated = customerService.getCustomerByEmail("test@example.com");
        assertEquals("New Address", updated.getAddress());
    }

    @Test
    void testAddAndRemoveFromCart() {
        customerService.addToCart("test@example.com", "prod1");
        customerService.addToCart("test@example.com", "prod2");
        List<String> cart = customerService.viewCart("test@example.com");
        assertTrue(cart.contains("prod1"));
        assertTrue(cart.contains("prod2"));

        customerService.removeFromCart("test@example.com", "prod1");
        cart = customerService.viewCart("test@example.com");
        assertFalse(cart.contains("prod1"));
        assertTrue(cart.contains("prod2"));
    }

    @Test
    void testPlaceOrderAndViewOrders() {
        customerService.addToCart("test@example.com", "prod1");
        customerService.addToCart("test@example.com", "prod2");
        customerService.placeOrder("test@example.com");

        List<String> orders = customerService.viewOrders("test@example.com");
        assertTrue(orders.contains("prod1"));
        assertTrue(orders.contains("prod2"));
        assertTrue(customerService.viewCart("test@example.com").isEmpty());
    }
}