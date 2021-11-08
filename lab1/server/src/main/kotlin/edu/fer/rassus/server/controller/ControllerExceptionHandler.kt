package edu.fer.rassus.server.controller

import edu.fer.rassus.server.controller.error.ApiError
import edu.fer.rassus.server.service.NoSensorException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception

@ControllerAdvice
class ControllerExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ApiError> {
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error.")
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(exception: IllegalArgumentException) : ResponseEntity<ApiError> {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, exception.message.orEmpty())
    }

    @ExceptionHandler(NoSensorException::class)
    fun handleNoSensorWithId(exception: NoSensorException): ResponseEntity<ApiError> {
        return buildResponseEntity(HttpStatus.NO_CONTENT, exception.message.orEmpty())
    }

    private fun buildResponseEntity(status: HttpStatus, message: String): ResponseEntity<ApiError> {
        return ResponseEntity(
            ApiError(
                message = message,
                status = status.value(),
                error = status.reasonPhrase
            ), status
        )
    }
}