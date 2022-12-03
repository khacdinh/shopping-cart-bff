package com.dino.shopping.cart.Service;

import com.dino.shopping.cart.repository.CustomerRepository;
import com.dino.shopping.cart.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email Invalid"));
    }

    public Customer signUp(Customer customer) {
        return customerRepository.save(customer);
    }
}
