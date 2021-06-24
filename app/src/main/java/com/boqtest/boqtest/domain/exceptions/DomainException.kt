package com.example.boqtest.domain.exceptions

/**
 * Represents a throwable domain exception. Exception have to be unchecked to be properly handled by
 * Rx Observables.
 *
 * @author nazmul
 */
abstract class DomainException(exceptionCode: Int,
                               exceptionMessage: String?,
                               throwable: Throwable?)
    : RuntimeException(exceptionMessage, throwable) {

    constructor(exceptionCode: Int, exceptionMessage: String?) :
            this(exceptionCode, exceptionMessage, null)

}
