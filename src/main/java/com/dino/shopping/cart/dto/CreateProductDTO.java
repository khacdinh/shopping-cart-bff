package com.dino.shopping.cart.dto;

import com.dino.shopping.cart.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
@Builder
public class CreateProductDTO {

    @JsonProperty("author")
    private String author;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image")
    private String image;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("title")
    private String title;

    @JsonProperty("quantity")
    private Integer quantity;

    public Product convertDTOtoEntity() throws IOException {
        return Product.builder()
                .author(getAuthor())
                .deleted(false)
                .description(getDescription())
                .price(getPrice())
                .title(getTitle())
                .image(getImage())
                .quantity(getQuantity())
                .build();
    }

}
