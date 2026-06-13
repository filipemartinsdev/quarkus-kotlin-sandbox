package com.sandbox.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity @Table(name = "product_category")
class ProductCategory (
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: Long,
    var name: String
)