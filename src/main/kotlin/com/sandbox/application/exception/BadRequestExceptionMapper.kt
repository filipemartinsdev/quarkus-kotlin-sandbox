package com.sandbox.application.exception

import io.github.responsekit.core.StandardResponse
import jakarta.ws.rs.BadRequestException
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class BadRequestExceptionMapper: ExceptionMapper<BadRequestException> {
    override fun toResponse(exception: BadRequestException): Response {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(StandardResponse.fail(exception.message).build())
                .build()
    }
}