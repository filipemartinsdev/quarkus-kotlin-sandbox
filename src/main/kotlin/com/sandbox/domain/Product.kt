package com.sandbox.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.validator.constraints.Length
import java.time.Instant
import java.util.UUID

@Entity @Table(name = "product")
class Product (
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Length(max = 256)
    var name: String = "",

    @Length(max = 256)
    var description: String? = null,

    @NotNull
    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    var category: ProductCategory? = null,

    @CreationTimestamp
    @Column(name = "created_at")
    var createdAt: Instant = Instant.now()
)