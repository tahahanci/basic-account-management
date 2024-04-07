package org.hncdev.accountmanagement.service;

import org.assertj.core.api.Assert;
import org.assertj.core.util.Sets;
import org.hncdev.accountmanagement.dto.CustomerDto;
import org.hncdev.accountmanagement.dto.CustomerDtoConverter;
import org.hncdev.accountmanagement.exception.CustomerNotFoundException;
import org.hncdev.accountmanagement.model.Customer;
import org.hncdev.accountmanagement.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private CustomerDtoConverter converter;

    @BeforeEach
    public void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        converter = Mockito.mock(CustomerDtoConverter.class);
        customerService = new CustomerService(customerRepository, converter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer() {
        Customer customer = new Customer("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(java.util.Optional.of(customer));
        Customer result = customerService.findCustomerById("id");

        assertEquals(result, customer);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException() {
        Mockito.when(customerRepository.findById("id")).thenReturn(java.util.Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.findCustomerById("id"));
    }

    @Test
    public void testGetCustomerById_whenCustomerIdDoesNotExists_shouldReturnCustomer() {
        Customer customer = new Customer("id", "name", "surname", Set.of());
        CustomerDto customerDto = new CustomerDto("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(java.util.Optional.of(customer));
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.getCustomerById("id");

        assertEquals(result, customerDto);
    }

    @Test
    public void testGetCustomerById_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException() {
        Mockito.when(customerRepository.findById("id")).thenReturn(java.util.Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById("id"));
        Mockito.verifyNoInteractions(converter);
    }

}