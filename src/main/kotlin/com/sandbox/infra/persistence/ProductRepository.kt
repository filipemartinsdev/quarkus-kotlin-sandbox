package com.sandbox.infra.persistence

import com.sandbox.domain.Product
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class ProductRepository: PanacheRepositoryBase<Product, UUID> {
    fun existsByName(name: String): Boolean {
//        return find("name", name).firstResult<Product>() != null
        return count("name", name) > 0
    }
}
