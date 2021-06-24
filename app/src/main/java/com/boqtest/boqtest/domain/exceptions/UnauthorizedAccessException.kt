package com.example.boqtest.domain.exceptions

/**
 * Triggered when a user has no access rights to the requested resource (eg. not logged in).

 * @author kamalmohamed
 */
class UnauthorizedAccessException :
        DomainException(DomainExceptionCodes.UNAUTHORIZED_ACCESS, "Unauthorized access")