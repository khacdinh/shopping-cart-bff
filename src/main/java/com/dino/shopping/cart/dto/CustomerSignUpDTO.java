package com.dino.shopping.cart.dto;

import com.dino.shopping.cart.entity.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@Builder
public class CustomerSignUpDTO {
    @JsonProperty("email")
    @Email
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("phone")
    private String phone;

    public Customer toEntity() {
        return Customer.builder()
                .address(getAddress())
                .email(getEmail())
                .password(getPassword())
                .fullName(getFullName())
                .city(getCity())
                .country(getCountry())
                .phone(getPhone())
                .deleted(false)
                .build();
    }
}
