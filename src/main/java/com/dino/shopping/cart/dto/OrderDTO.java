package com.dino.shopping.cart.dto;

import com.dino.shopping.cart.entity.Customer;
import com.dino.shopping.cart.entity.ProductOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Getter
public class OrderDTO {

    @JsonProperty("customerId")
    private Long customerId;

    @JsonProperty("recipientName")
    private String recipientName;

    @JsonProperty("shippingAddress")
    private String shippingAddress;

    @JsonProperty("recipientPhone")
    private String recipientPhone;

    @JsonProperty("products")
    private List<ProductDetailDTO> products;


    public ProductOrder toEntity(Customer customer) {
        return ProductOrder.builder()
                .orderDate(Instant.now())
                .recipientName(recipientName)
                .shippingAddress(shippingAddress)
                .recipientPhone(recipientPhone)
                .total(calculateTotal())
                .deleted(false)
                .customerId(customer)
                .orderDetails(new HashSet<>())
                .build();
    }

    private Float calculateTotal() {
        AtomicReference<Float> totalPay = new AtomicReference<>(0F);
        products.forEach((productDetailDTO) -> {
            totalPay.updateAndGet(v -> v + (productDetailDTO.getPrice() * productDetailDTO.getQuantity()));
        });
        return totalPay.get();
    }

}
