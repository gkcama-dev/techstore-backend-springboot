package com.techstore.api.service;
import com.techstore.api.dto.OrderRequest;
import com.techstore.api.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(OrderRequest orderRequest);
    List<Order> getOrdersByCustomer(Long customerId);
}
