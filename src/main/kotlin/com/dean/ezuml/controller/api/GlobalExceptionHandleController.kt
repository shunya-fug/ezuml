package com.dean.ezuml.controller.api

import com.dean.ezuml.response.common.BindingResultItem
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandleController {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidExceptionHandler(e: MethodArgumentNotValidException) =
        ResponseEntity.badRequest().body(e.fieldErrors.map {
            BindingResultItem(it.field, it.defaultMessage.toString())
        }.toList())

}
