package project.semicolon.ecommercebackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.semicolon.ecommercebackend.Exceptions.EmailAlreadyExistException;
import project.semicolon.ecommercebackend.Exceptions.InvalidEmailException;
import project.semicolon.ecommercebackend.Exceptions.PhoneNumberAlreadyExistException;
import project.semicolon.ecommercebackend.data.models.User;
import project.semicolon.ecommercebackend.data.repository.CustomerRepository;
import project.semicolon.ecommercebackend.data.repository.SellerRepository;
import project.semicolon.ecommercebackend.data.repository.UserRepository;
import project.semicolon.ecommercebackend.dtos.Requests.LoginRequest;
import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.LoginResponse;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;
import project.semicolon.ecommercebackend.utils.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) throws EmailAlreadyExistException, InvalidEmailException {
//            isUserRegistered(registerRequest);
            User user = UserMapper.mapToUser(registerRequest);
            User savedUser = userRepository.save(user);
            return UserMapper.getRegisterResponse(savedUser);
        }


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse response = new LoginResponse();
        User user = userRepository.findUsersByEmail(loginRequest.getEmail())
                .orElseThrow();

        if (user.getPassword().equals(loginRequest.getPassword())) {
            response.setMessage("Login successful");
        } else {
            response.setMessage("Invalid email or password");
        }
        return response;
    }
    @Override
    public void logout(String email) {
        if (email == null || email.trim().isEmpty())
            try {
                throw new InvalidEmailException("Email cannot be null or empty");
            } catch (InvalidEmailException e) {
                throw new RuntimeException(e);
            }

        userRepository.findUsersByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    public User getUserByEmail(String email) throws InvalidEmailException {
        if (email == null || email.trim().isEmpty())
            throw new InvalidEmailException("Email cannot be null or empty");

        return userRepository.findUsersByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    private void isUserRegistered(RegisterRequest registerRequest)
            throws EmailAlreadyExistException, PhoneNumberAlreadyExistException {
        if (userRepository.existsByEmail(registerRequest.getEmail()))
            throw new EmailAlreadyExistException("Email already exists");
        if (userRepository.existsByPhoneNumber(registerRequest.getPhoneNumber()))
            throw new PhoneNumberAlreadyExistException("Phone number already exists");
    }
}