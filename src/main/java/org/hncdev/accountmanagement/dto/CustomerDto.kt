package org.hncdev.accountmanagement.dto

data class CustomerDto(
    val id: String,
    val name: String,
    val surname: String,
    val customers: Set<CustomerAccountDto>
)
