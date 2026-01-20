package com.techstore.api.service;
import com.techstore.api.dto.OrderRequest;
import com.techstore.api.model.Order;

public interface OrderService {
    Order placeOrder(OrderRequest orderRequest);
}
