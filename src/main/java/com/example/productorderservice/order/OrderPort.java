package com.example.productorderservice.order;

import com.example.productorderservice.product.domain.Product;

interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
