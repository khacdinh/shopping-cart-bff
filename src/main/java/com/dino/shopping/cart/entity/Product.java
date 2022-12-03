package com.dino.shopping.cart.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
@Setter
@Getter
@Builder
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true, nullable = false, length = 200)
    private String title;

    @Column(name = "author", nullable = false, length = 50)
    private String author;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    Set<OrderDetail> orderDetails;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

}
