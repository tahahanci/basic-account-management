package org.hncdev.accountmanagement.service;

import org.hncdev.accountmanagement.dto.AccountDto;
import org.hncdev.accountmanagement.dto.CreateAccountRequest;
import org.hncdev.accountmanagement.exception.CustomerNotFoundException;
import org.hncdev.accountmanagement.model.Customer;
import org.hncdev.accountmanagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer with id " + id + " not found")
        );
    }



}
