package com.techstore.api.repository;

import com.techstore.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Customer ID by Orders
    List<Order> findByCustomerId(Long customerId);
}