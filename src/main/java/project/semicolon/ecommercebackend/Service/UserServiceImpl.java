package project.semicolon.ecommercebackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.semicolon.ecommercebackend.Enums.Role;
import project.semicolon.ecommercebackend.data.models.User;
import project.semicolon.ecommercebackend.data.repository.CustomerRepository;
import project.semicolon.ecommercebackend.data.repository.SellerRepository;
import project.semicolon.ecommercebackend.data.repository.UserRepository;
import project.semicolon.ecommercebackend.dtos.Requests.RegisterRequest;
import project.semicolon.ecommercebackend.dtos.Responses.RegisterResponse;
import project.semicolon.ecommercebackend.utils.Mapper;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SellerRepository sellerRepository;




    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user;
        if( user =userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("Email already exists");
        }

//        User user = Mapper.mapToUser(registerRequest);
        user.setPassword(registerRequest.getPassword());

        userRepository.save(user);
        if(user.getRole() == Role.CUSTOMER){
            customerRepository.save(Mapper.mapToCustomer(user));
        } else if(user.getRole() == Role.SELLER){
            sellerRepository.save(Mapper.mapToSeller(user));
        }
        return Mapper.mapToRegisterResponse(user , "Registration successful");

        }
    }
}
