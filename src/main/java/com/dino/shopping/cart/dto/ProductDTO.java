package com.dino.shopping.cart.dto;

import com.dino.shopping.cart.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class ProductDTO {

    @JsonProperty("id")
    private Long id;

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

    public static Product convertDTOtoEntity(ProductDTO dto) throws IOException {
        return Product.builder()
                .id(dto.getId())
                .author(dto.getAuthor())
                .deleted(false)
                .description(dto.getDescription())
                .price(dto.getPrice())
                .title(dto.getTitle())
                .image(dto.getImage())
                .build();
    }

    public static List<ProductDTO> convertEntitiestoDTOS(List<Product> entities) throws IOException {
        return entities.stream().map(e -> ProductDTO.builder()
                .id(e.getId())
                .author(e.getAuthor())
                .description(e.getDescription())
                .price(e.getPrice())
                .title(e.getTitle())
                .image(e.getImage())
                .quantity(e.getQuantity())
                .build()).collect(Collectors.toList());
    }
}
