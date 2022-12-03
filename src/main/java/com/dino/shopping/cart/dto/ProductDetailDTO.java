package com.dino.shopping.cart.dto;

import com.dino.shopping.cart.entity.OrderDetail;
import com.dino.shopping.cart.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("price")
    @JsonIgnoreProperties
    private Float price;

    public OrderDetail toEntity(Product product) {
        return OrderDetail.builder()
                .total(quantity)
                .product(product)
                .subTotal(calculateSubTotal())
                .build();
    }

    public Float calculateSubTotal() {
        return price * quantity;
    }
}
