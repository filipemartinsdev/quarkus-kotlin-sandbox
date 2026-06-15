package com.sandbox.application.dto

import jakarta.validation.constraints.NotEmpty

@JvmRecord
data class CreateProductRequest(
    val name: @NotEmpty String,
    val description: String?,
    val categoryId: Int
)
