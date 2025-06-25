package project.semicolon.ecommercebackend.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.semicolon.ecommercebackend.dtos.Requests.CartRequest;
import project.semicolon.ecommercebackend.dtos.Responses.CartResponse;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CartServiceImplTest {

    @Autowired
    private CartServiceImpl cartService;

    @Test
    public void testToAddToCart(){
        CartRequest request = new CartRequest();
        request.setName("bode001");
        request.setPrice(200.0);
        request.setQuantity(2);
        request.setUserId("bod123");

        CartResponse response = cartService.addToCart(request);
        assertEquals(400.0, response.getTotalPrice());
    }

}