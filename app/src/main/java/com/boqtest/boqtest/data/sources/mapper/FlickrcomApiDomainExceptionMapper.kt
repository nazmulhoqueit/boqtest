package com.example.boqtest.data.sources.mapper

import com.example.boqtest.domain.exceptions.DomainException
import com.example.boqtest.domain.exceptions.NoConnectivityException
import com.example.boqtest.domain.exceptions.UnexpectedServerException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class FlickrcomApiDomainExceptionMapper {

    companion object {

        /**
         * Maps the result of a failed API call to a meaningful DomainException.
         *
         * @param throwable result of a failed API call.
         * @return DomainException that matches the provided throwable.
         */
        fun map(throwable: Throwable): DomainException {
            when (throwable) {
                is DomainException ->
                    return throwable
                is UnknownHostException, is SocketTimeoutException, is ConnectException ->
                    return NoConnectivityException()
                else ->
                    return UnexpectedServerException()
            }
        }
    }

}