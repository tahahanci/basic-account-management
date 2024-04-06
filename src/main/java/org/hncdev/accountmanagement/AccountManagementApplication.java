package org.hncdev.accountmanagement;

import org.hncdev.accountmanagement.model.Customer;
import org.hncdev.accountmanagement.repository.AccountRepository;
import org.hncdev.accountmanagement.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class AccountManagementApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public AccountManagementApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository
                .save(new Customer("", "Taha", "Hanci", new HashSet<>()));
        System.out.println(customer.getId());
    }
}
