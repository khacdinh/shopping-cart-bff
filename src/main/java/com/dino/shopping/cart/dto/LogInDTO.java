package com.dino.shopping.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LogInDTO {
    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
}
