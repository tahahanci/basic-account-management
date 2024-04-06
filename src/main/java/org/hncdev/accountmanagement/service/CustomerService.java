package org.hncdev.accountmanagement.service;

import org.hncdev.accountmanagement.dto.CustomerDto;
import org.hncdev.accountmanagement.dto.CustomerDtoConverter;
import org.hncdev.accountmanagement.exception.CustomerNotFoundException;
import org.hncdev.accountmanagement.model.Customer;
import org.hncdev.accountmanagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer with id " + id + " not found")
        );
    }

    public CustomerDto getCustomerById(String id) {
        return converter.convertToCustomerDto(findCustomerById(id));
    }



}
