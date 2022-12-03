package com.dino.shopping.cart.rest;

import com.dino.shopping.cart.dto.CustomerSignUpDTO;
import com.dino.shopping.cart.dto.LogInDTO;
import com.dino.shopping.cart.Service.CustomerService;
import com.dino.shopping.cart.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<Long> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id).getId());
    }

    @PostMapping("/customer/log-in")
    public ResponseEntity<?> logIn(@RequestBody LogInDTO logInDTO) {
        Customer customer = customerService.findByEmail(logInDTO.getEmail());
        if (customer.getPassword().equals(logInDTO.getPassword())) {
            return ResponseEntity.ok(customer.getId());
        } else {
            return ResponseEntity.badRequest().body("Password Invalid!!!");
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<?> signUp(@RequestBody @Valid CustomerSignUpDTO customerDTO) {
        customerService.signUp(customerDTO.toEntity());
        return ResponseEntity.ok().build();
    }
}
