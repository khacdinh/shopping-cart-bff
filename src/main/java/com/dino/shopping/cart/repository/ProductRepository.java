package com.dino.shopping.cart.repository;

import com.dino.shopping.cart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
