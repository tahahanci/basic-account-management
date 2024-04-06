package org.hncdev.accountmanagement.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(

    val id: String,
    val balance: BigDecimal?,
    val transactions: Set<TransactionDto>?,
    val creationDate: LocalDateTime

)
