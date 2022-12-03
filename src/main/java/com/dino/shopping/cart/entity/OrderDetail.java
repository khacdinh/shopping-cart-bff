package com.dino.shopping.cart.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable {

    @EmbeddedId
    private ProductOrderId id = new ProductOrderId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private ProductOrder order;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "subtotal", nullable = false)
    private Float subTotal;

}
