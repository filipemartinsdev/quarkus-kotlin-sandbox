package com.sandbox.infra.persistence

import com.sandbox.domain.ProductCategory
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProductCategoryRepository: PanacheRepositoryBase<ProductCategory, Long>
