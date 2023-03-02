package com.waterfogsw.timedeal.common.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(LoginFailedException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleLoginFailedException(exception: LoginFailedException) = logAndReturnMessage(exception)

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(exception: NotFoundException) = logAndReturnMessage(exception)

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception) = logAndReturnMessage(exception)

    private fun logAndReturnMessage(exception: Exception): String {
        val message = exception.message.toString()
        log.info("$exception: $message")
        return message
    }
}
