package org.hncdev.accountmanagement.dto

import org.hncdev.accountmanagement.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(

    val id: String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?
)
