package com.example.boqtest.presentation.components
/**
 * Defines methods to handle errors across the app.
 */
interface ErrorComponent {

    /**
     * Performs actions according to the error.
     *
     * @param throwable Throwable that contains error information.
     */
    fun handleError(throwable: Throwable)

}