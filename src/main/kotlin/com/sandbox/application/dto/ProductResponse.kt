package com.sandbox.application.dto

import java.time.Instant
import java.util.UUID

data class ProductResponse(
    val id: UUID,
    val name: String,
    val description: String?,
    val category: ProductCategoryResponse,
    val createdAt: Instant
)
