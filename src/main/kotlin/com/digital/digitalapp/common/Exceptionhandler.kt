package com.digital.digitalapp.common

import com.digital.digitalapp.common.model.error.ErrorResponse
import com.digital.digitalapp.common.model.error.Errors
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import com.digital.digitalapp.common.model.error.Error
import java.time.LocalDateTime

@RestControllerAdvice
class Exceptionhandler {

    @ExceptionHandler(value = [Exception::class])
    fun handle(e: Exception): HttpEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(
                arrayOf(
                    Errors(
                        rootCauses = listOf(
                            Error(reason = e.message.toString())
                        ),
                        reason = "Products Not dound",
                        datetime = LocalDateTime.now()
                    )
                )
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}
