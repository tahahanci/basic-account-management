package org.hncdev.accountmanagement.service;

import org.hncdev.accountmanagement.dto.AccountDto;
import org.hncdev.accountmanagement.dto.AccountDtoConverter;
import org.hncdev.accountmanagement.dto.CreateAccountRequest;
import org.hncdev.accountmanagement.model.Account;
import org.hncdev.accountmanagement.model.Customer;
import org.hncdev.accountmanagement.model.Transaction;
import org.hncdev.accountmanagement.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
        Account account = new Account(customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(), account);
            account.getTransactions().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

}
