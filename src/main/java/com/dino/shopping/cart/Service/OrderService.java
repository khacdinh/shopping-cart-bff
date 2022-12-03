package com.dino.shopping.cart.Service;

import com.dino.shopping.cart.repository.ProductOrderRepository;
import com.dino.shopping.cart.entity.OrderDetail;
import com.dino.shopping.cart.entity.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductService productService;

    public void saveOrder(ProductOrder productOrder, Set<OrderDetail> orderDetails) {
        orderDetails.forEach(orderDetail -> {
            OrderDetail ot = new OrderDetail();
            ot.setOrder(productOrder);
            ot.setTotal(orderDetail.getTotal());
            ot.setSubTotal(orderDetail.getSubTotal());
            ot.setProduct(orderDetail.getProduct());
            productOrder.getOrderDetails().add(ot);
            productService.updateQuantityAfterPlaceOrder(orderDetail.getProduct(), orderDetail.getTotal());
        });
        productOrderRepository.save(productOrder);
    }


}
