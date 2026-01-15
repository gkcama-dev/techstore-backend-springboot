package com.techstore.api.service;

import com.techstore.api.dto.CustomerDTO;
import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
}