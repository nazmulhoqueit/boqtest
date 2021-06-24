package com.example.boqtest.domain.exceptions

/**
 * @author nazmul
 */
class UnexpectedServerException :
        DomainException(DomainExceptionCodes.UNEXPECTED_SERVER, "Server error") {
}