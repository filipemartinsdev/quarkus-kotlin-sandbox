package com.sandbox.application.service

import com.sandbox.application.dto.CreateProductRequest
import com.sandbox.application.dto.ProductResponse
import com.sandbox.application.service.mapper.ProductMapper
import com.sandbox.domain.Product
import com.sandbox.domain.ProductCategory
import com.sandbox.infra.persistence.ProductCategoryRepository
import com.sandbox.infra.persistence.ProductRepository
import com.sandbox.infra.web.ProductResource
import io.github.responsekit.core.PagedResponse
import io.github.responsekit.quarkus.PagedResponseFactory
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import java.util.UUID

@ApplicationScoped
class ProductService (
    private val productRepository: ProductRepository,
    private val productCategoryRepository: ProductCategoryRepository,
    private val productMapper: ProductMapper,
    private val productResource: ProductResource,
    private val entityManager: EntityManager
){

    fun getAll(page: Int, size: Int): PagedResponse<ProductResponse> {
        return PagedResponseFactory.fromQuery(
            productRepository.findAll().page(page, size),
            productMapper::toResponse
        )
    }

    fun getById(id: UUID): ProductResponse {}

    fun create(request: CreateProductRequest): ProductResponse {
        val product: Product = Product()

        product.name = request.name
        product.description = request.description
        product.category = entityManager.getReference(ProductCategory::class.java, request.categoryId)

        return productMapper.toResponse(
            productRepository
        )
    }
}