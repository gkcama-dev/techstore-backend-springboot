package com.techstore.api.service.impl;

import com.techstore.api.dto.CustomerDTO;
import com.techstore.api.model.Customer;
import com.techstore.api.repository.CustomerRepository;
import com.techstore.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        // Email exists
        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            throw new RuntimeException("Email already exists: " + customerDTO.getEmail());
        }

        // DTO -> Entity (Mapping)
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());

        // Save to Database
        Customer savedCustomer = customerRepository.save(customer);

        //Entity -> DTO (Return)
        return mapToDTO(savedCustomer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        // Java Stream API convert -> List
        return customers.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Helper Method: Entity -> DTO
    private CustomerDTO mapToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setAddress(customer.getAddress());
        return dto;
    }
}