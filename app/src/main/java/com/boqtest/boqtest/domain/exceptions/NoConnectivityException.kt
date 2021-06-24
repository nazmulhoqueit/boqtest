package com.example.boqtest.domain.exceptions

/**
 * @author nazmul
 */
class NoConnectivityException :
        DomainException(DomainExceptionCodes.NO_INTERNET_CONNECTION,"No Internet connection") {
}