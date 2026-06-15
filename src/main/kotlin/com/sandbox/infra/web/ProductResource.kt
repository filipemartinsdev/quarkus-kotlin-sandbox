package com.sandbox.infra.web

import com.sandbox.application.dto.CreateProductRequest
import com.sandbox.application.dto.ProductResponse
import com.sandbox.application.service.ProductService
import io.github.responsekit.core.PagedResponse
import io.github.responsekit.core.StandardResponse
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestPath
import org.jboss.resteasy.reactive.RestQuery
import org.jboss.resteasy.reactive.RestResponse
import java.util.*

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ProductResource (
    private val productService: ProductService
){

    @POST
    fun create(request: CreateProductRequest): RestResponse<StandardResponse<ProductResponse>>{
        return RestResponse.ok(
            StandardResponse.success(
                productService.create(request)
            ).build()
        )
    }

    @GET
    fun getAll(
        @RestQuery @DefaultValue("0") page: Int,
        @RestQuery @DefaultValue("20") size: Int
    ): RestResponse<StandardResponse<PagedResponse<ProductResponse>>> {
        return RestResponse.ok(
            StandardResponse.success(
                productService.getAll(page, size)
            ).build()
        )
    }

    @GET @Path("/{id}")
    fun getById(@RestPath id: UUID): RestResponse<StandardResponse<ProductResponse>> {
        return RestResponse.ok(
            StandardResponse.success(
                productService.getById(id)
            ).build()
        )
    }
}