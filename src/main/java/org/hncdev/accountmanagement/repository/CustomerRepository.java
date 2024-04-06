package org.hncdev.accountmanagement.repository;

import org.hncdev.accountmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
