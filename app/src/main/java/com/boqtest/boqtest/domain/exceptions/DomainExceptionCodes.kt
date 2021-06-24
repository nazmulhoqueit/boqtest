package com.example.boqtest.domain.exceptions

/**
 * A list of the codes used for the various DomainExceptions.
 *
 * 1xx codes are reserved for expected business logic errors.

 * @author nazmul
 */
object DomainExceptionCodes {
    val UNEXPECTED_SERVER = 0
    val UNAUTHORIZED_ACCESS = 1
    val NO_INTERNET_CONNECTION = 2
}