package com.techstore.api.repository;

import com.techstore.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find Customer by Email ?
    boolean existsByEmail(String email);

    // Find Customer by Email
    Customer findByEmail(String email);
}