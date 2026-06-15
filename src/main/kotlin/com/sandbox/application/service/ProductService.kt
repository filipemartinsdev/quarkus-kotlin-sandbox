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
import jakarta.transaction.Transactional
import jakarta.ws.rs.BadRequestException
import jakarta.ws.rs.NotFoundException
import java.time.Instant
import java.util.UUID

@ApplicationScoped
class ProductService (
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper,
    private val entityManager: EntityManager
){

    fun getAll(page: Int, size: Int): PagedResponse<ProductResponse> {
        return PagedResponseFactory.fromQuery(
            productRepository.findAll().page(page, size),
            productMapper::toResponse
        )
    }

    fun getById(id: UUID): ProductResponse {
        return productMapper.toResponse(
            productRepository.findById(id)
                    ?: throw NotFoundException("Product not found by ID: $id")
        )
    }

    @Transactional
    fun create(request: CreateProductRequest): ProductResponse {
        if (productRepository.existsByName(request.name))
            throw BadRequestException("Name already exists: ${request.name}")

        val product = Product(
            name = request.name,
            description = request.description,
            category = entityManager.getReference(ProductCategory::class.java, request.categoryId)
        )

        productRepository.persist(product)

        return productMapper.toResponse(product)
    }
}