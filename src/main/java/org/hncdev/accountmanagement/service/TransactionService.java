package org.hncdev.accountmanagement.service;

import org.hncdev.accountmanagement.model.Account;
import org.hncdev.accountmanagement.model.Transaction;
import org.hncdev.accountmanagement.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount) {
        return transactionRepository.save(new Transaction(amount, account));
    }
}
