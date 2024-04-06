package org.hncdev.accountmanagement.repository;

import org.hncdev.accountmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
