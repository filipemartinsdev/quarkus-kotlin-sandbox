package com.sandbox.application.dto

data class CreateProductRequest(
    val name: String,
    val description: String?,
    val categoryId: Long
)
