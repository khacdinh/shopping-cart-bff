package com.dino.shopping.cart.rest;


import com.dino.shopping.cart.dto.OrderDTO;
import com.dino.shopping.cart.Service.CustomerService;
import com.dino.shopping.cart.Service.OrderService;
import com.dino.shopping.cart.Service.ProductService;
import com.dino.shopping.cart.entity.Customer;
import com.dino.shopping.cart.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @PostMapping("order")
    public ResponseEntity<?> order(@RequestBody OrderDTO orderDTO) {
        orderDTO.getProducts().forEach(productDetailDTO -> {
            productDetailDTO.setPrice(productService.findById(productDetailDTO.getId()).getPrice());
        });
        Customer customer = customerService.findById(orderDTO.getCustomerId());
        Set<OrderDetail> orderDetails = orderDTO.getProducts().stream()
                .map(productDetailDTO -> productDetailDTO.toEntity(productService.findById(productDetailDTO.getId())))
                .collect(Collectors.toSet());

        orderService.saveOrder(orderDTO.toEntity(customer), orderDetails);

        return  ResponseEntity.ok().build();
    }
}
