package com.dino.shopping.cart.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@Setter
@Getter
@Builder
@SQLDelete(sql = "UPDATE customer SET deleted = true WHERE id=?")
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "password", nullable = false, length = 225)
    private String password;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;
}
