package com.dino.shopping.cart.Service;

import com.dino.shopping.cart.repository.ProductRepository;
import com.dino.shopping.cart.dto.CreateProductDTO;
import com.dino.shopping.cart.dto.ProductDTO;
import com.dino.shopping.cart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public CreateProductDTO createProduct(CreateProductDTO createProductDTO) throws IOException {
        productRepository.save(createProductDTO.convertDTOtoEntity());
        return createProductDTO;
    }

    public List<ProductDTO> getAllProducts() throws IOException {
        return ProductDTO.convertEntitiestoDTOS(productRepository.findAll());
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Id"));
    }

    public void updateQuantityAfterPlaceOrder(Product product, Integer boughtNo) {
        if (product.getQuantity() < boughtNo) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough products in stock!!!");
        } else {
            product.setQuantity(product.getQuantity() - boughtNo);
            productRepository.save(product);
        }
    }

}
