package project.semicolon.ecommercebackend.utils;

<<<<<<< HEAD
import project.semicolon.ecommercebackend.data.models.Cart;
import project.semicolon.ecommercebackend.data.models.CartItems;
import project.semicolon.ecommercebackend.data.models.Order;
import project.semicolon.ecommercebackend.dtos.Requests.CartRequest;
import project.semicolon.ecommercebackend.dtos.Requests.OrderRequest;
import project.semicolon.ecommercebackend.dtos.Responses.CartResponse;
import project.semicolon.ecommercebackend.dtos.Responses.OrderResponse;

public class Mapper {

    public static CartItems mapToCartItems(CartRequest request) {
        CartItems items = new CartItems();
        items.setProductId(request.getProductId());
        items.setName(request.getName());
        items.setQuantity(request.getQuantity());
        items.setPrice(request.getPrice());
        return items;
    }

    public static CartResponse mapToAddCartResponse(Cart cart) {
        CartResponse response = new CartResponse();
        response.setUserId(cart.getUserId());
        response.setItems(cart.getItems());
        response.setTotalPrice(cart.getTotalPrice());
        return response;
    }

    public static Order mapToOrder(OrderRequest request){
        Order order = new Order();
        order.setUserid(request.getUserId());
        order.setTotalPrice(request.getPrice());
        order.setItems(request.getItems());
        return order;
    }

    public static OrderResponse mapToOrderResponse(Order order){
        OrderResponse response = new OrderResponse();
        response.setUserId(order.getUserid());
        response.setOrderId(order.getOrderId());
        response.setCreatedAt(order.getCreatedAt());
        response.setDeliveryAddress(order.getDeliveryAddress());
        response.setTotalPrice(order.getTotalPrice());
        response.setItems(order.getItems());
        return response;
=======
import project.semicolon.ecommercebackend.Enums.Role;
import project.semicolon.ecommercebackend.Exceptions.InvalidEmailException;
import project.semicolon.ecommercebackend.data.models.User;
import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;

public class Mapper {

    public static User RegisterRequestToUser(RegisterRequest registerRequest) throws InvalidEmailException {
        isValidUser(registerRequest);

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setRole(registerRequest.getRole());
        return user;
    }

    public static RegisterResponse getRegisterResponse(User savedUser) {
        RegisterResponse response = new RegisterResponse();
        response.setId(savedUser.getId());
        response.setMessage("User registered successfully");
        return response;
    }

    private static void isValidUser(RegisterRequest registerRequest) throws InvalidEmailException {
        validateEmail(registerRequest.getEmail());
        validatePhoneNumber(registerRequest.getPhoneNumber());
        validateFirstName(registerRequest.getFirstName());
        validateLastName(registerRequest.getLastName());
        validateRole(registerRequest.getRole());
    }

    private static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || email.trim().isEmpty())
            throw new InvalidEmailException("Email cannot be empty");
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new InvalidEmailException("Invalid email format");
    }

    private static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) throw new RuntimeException("Phone number cannot be empty");
        if (phoneNumber.length() != 11) throw new RuntimeException("Phone number must be 11 digits");
        if (!phoneNumber.matches("^\\+?[0-9]{7,15}$")) throw new RuntimeException("Invalid phone number format");
    }

    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty())
            throw new RuntimeException("First name cannot be empty");
    }

    private static void validateLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty())
            throw new RuntimeException("Last name cannot be empty");
    }

    private static void validateRole(Role role) {
        if (role == null)
            throw new RuntimeException("Role cannot be null");
    }

    public static User  mapToUser(RegisterRequest registerRequest) throws InvalidEmailException {
        return RegisterRequestToUser(registerRequest);
>>>>>>> origin/main
    }
}