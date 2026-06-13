package com.sandbox.application.service.mapper

import com.sandbox.application.dto.ProductCategoryResponse
import com.sandbox.application.dto.ProductResponse
import com.sandbox.domain.Product
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProductMapper {
    fun toResponse(entity: Product): ProductResponse {
        return ProductResponse(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            category = ProductCategoryResponse(entity.category.id, entity.category.name),
            createdAt = entity.createdAt,
        )
    }
}