package com.dino.shopping.cart.rest;

import com.dino.shopping.cart.dto.CreateProductDTO;
import com.dino.shopping.cart.dto.ProductDTO;
import com.dino.shopping.cart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<ProductDTO>> get() throws IOException {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping(value = "product", consumes = "multipart/form-data")
    public ResponseEntity<CreateProductDTO> create(@RequestParam MultipartFile image,
                                                   @RequestParam String author,
                                                   @RequestParam String title,
                                                   @RequestParam String description,
                                                   @RequestParam Float price,
                                                   @RequestParam Integer quantity
                                                   ) throws IOException {


        return ResponseEntity.ok(productService.createProduct(
                CreateProductDTO.builder()
                        .author(author)
                        .price(price)
                        .title(title)
                        .description(description)
                        .quantity(quantity)
                        .build()));
    }

}
