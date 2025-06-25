package project.semicolon.ecommercebackend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.semicolon.ecommercebackend.Service.CustomerService;
import project.semicolon.ecommercebackend.data.models.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{email}")
    public Customer getCustomer(@PathVariable String email) {
        return customerService.getCustomerByEmail(email);
    }

    @PutMapping("/{email}/address")
    public void updateAddress(@PathVariable String email, @RequestParam String address) {
        customerService.updateAddress(email, address);
    }

    @PostMapping("/{email}/cart")
    public void addToCart(@PathVariable String email, @RequestParam String productId) {
        customerService.addToCart(email, productId);
    }

    @DeleteMapping("/{email}/cart")
    public void removeFromCart(@PathVariable String email, @RequestParam String productId) {
        customerService.removeFromCart(email, productId);
    }

    @GetMapping("/{email}/cart")
    public List<String> viewCart(@PathVariable String email) {
        return customerService.viewCart(email);
    }

    @PostMapping("/{email}/orders")
    public void placeOrder(@PathVariable String email) {
        customerService.placeOrder(email);
    }

    @GetMapping("/{email}/orders")
    public List<String> viewOrders(@PathVariable String email) {
        return customerService.viewOrders(email);
    }
}