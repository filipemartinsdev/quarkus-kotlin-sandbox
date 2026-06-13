package com.sandbox.infra.persistence

import com.sandbox.domain.Product
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class ProductRepository: PanacheRepositoryBase<Product, UUID>
