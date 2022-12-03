package com.dino.shopping.cart.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "product_order")
@Setter
@Getter
@SQLDelete(sql = "UPDATE product_order SET deleted = true WHERE id=?")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerId;

    @Column(name = "order_date", nullable = false)
    private Instant orderDate;

    @Column(name = "shipping_address", nullable = false, length = 100)
    private String shippingAddress;

    @Column(name = "recipient_name", nullable = false, length = 100)
    private String recipientName;

    @Column(name = "recipient_phone", nullable = false, length = 20)
    private String recipientPhone;

    @Column(name = "total", nullable = false)
    private Float total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    Set<OrderDetail> orderDetails;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;
}
