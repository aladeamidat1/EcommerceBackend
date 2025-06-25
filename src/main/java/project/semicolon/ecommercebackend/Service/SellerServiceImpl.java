package project.semicolon.ecommercebackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.semicolon.ecommercebackend.data.models.Seller;
import project.semicolon.ecommercebackend.data.repository.SellerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller getSellerByEmail(String email) {
        return sellerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Seller not found"));
    }

    @Override
    public void updateProfile(String email, String firstName, String lastName) {
        Seller seller = getSellerByEmail(email);
        seller.setFirstName(firstName);
        seller.setLastName(lastName);
        sellerRepository.save(seller);
    }

    @Override
    public void addProduct(String sellerEmail, String productId) {
        Seller seller = getSellerByEmail(sellerEmail);
        List<String> products = seller.getProductIds() == null ? new ArrayList<>() : seller.getProductIds();
        products.add(productId);
        seller.setProductIds(products);
        sellerRepository.save(seller);
    }

    @Override
    public List<String> viewProducts(String sellerEmail) {
        Seller seller = getSellerByEmail(sellerEmail);
        return seller.getProductIds() == null ? new ArrayList<>() : seller.getProductIds();
    }

    @Override
    public List<String> viewOrders(String sellerEmail) {
        Seller seller = getSellerByEmail(sellerEmail);
        return seller.getOrderIds() == null ? new ArrayList<>() : seller.getOrderIds();
    }
}