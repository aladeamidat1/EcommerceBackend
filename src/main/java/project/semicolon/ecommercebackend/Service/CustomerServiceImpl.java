package project.semicolon.ecommercebackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.semicolon.ecommercebackend.data.models.Customer;
import project.semicolon.ecommercebackend.data.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public void updateAddress(String email, String newAddress) {
        Customer customer = getCustomerByEmail(email);
        customer.setAddress(newAddress);
        customerRepository.save(customer);
    }

    @Override
    public void addToCart(String customerEmail, String productId) {
        Customer customer = getCustomerByEmail(customerEmail);
        List<String> cart = customer.getCartId() == null ? new ArrayList<>() : new ArrayList<>(List.of(customer.getCartId().split(",")));
        cart.add(productId);
        customer.setCartId(String.join(",", cart));
        customerRepository.save(customer);
    }

    @Override
    public void removeFromCart(String customerEmail, String productId) {
        Customer customer = getCustomerByEmail(customerEmail);
        List<String> cart = customer.getCartId() == null ? new ArrayList<>() : new ArrayList<>(List.of(customer.getCartId().split(",")));
        cart.remove(productId);
        customer.setCartId(String.join(",", cart));
        customerRepository.save(customer);
    }

    @Override
    public List<String> viewCart(String customerEmail) {
        Customer customer = getCustomerByEmail(customerEmail);
        if (customer.getCartId() == null || customer.getCartId().isEmpty()) return new ArrayList<>();
        return List.of(customer.getCartId().split(","));
    }

    @Override
    public void placeOrder(String customerEmail) {
        Customer customer = getCustomerByEmail(customerEmail);
        List<String> cart = viewCart(customerEmail);
        if (cart.isEmpty()) throw new RuntimeException("Cart is empty");
        List<String> orders = customer.getOrderIds() == null ? new ArrayList<>() : customer.getOrderIds();
        orders.addAll(cart);
        customer.setOrderIds(orders);
        customer.setCartId(""); // clear cart
        customerRepository.save(customer);
    }

    @Override
    public List<String> viewOrders(String customerEmail) {
        Customer customer = getCustomerByEmail(customerEmail);
        return customer.getOrderIds() == null ? new ArrayList<>() : customer.getOrderIds();
    }
}