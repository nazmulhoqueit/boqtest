package com.example.boqtest.presentation.components

import android.app.Activity
import android.view.View
import com.example.boqtest.R
import com.example.boqtest.domain.exceptions.NoConnectivityException
import com.example.boqtest.domain.exceptions.UnauthorizedAccessException
import com.google.android.material.snackbar.Snackbar

/**
 * @author Nazmul
 */
class ErrorComponentImpl(private val activity: Activity) : ErrorComponent {

    override fun handleError(throwable: Throwable) {
        when (throwable) {
            is NoConnectivityException ->
                showNonBlockingConnectivityErrorMessage()
            is UnauthorizedAccessException ->
                showUnauthorizeErrorMessage()
            else ->
                showNonBlockingServerErrorMessage()
        }
    }
    private fun showNonBlockingConnectivityErrorMessage() {
        showErrorSnackbar(activity.getString(R.string.snackbar_message_error_network))
    }

    private fun showNonBlockingServerErrorMessage() {
        showErrorSnackbar(activity.getString(R.string.snackbar_message_error_server))
    }

    private fun showUnauthorizeErrorMessage() {
        showErrorSnackbar(activity.getString(R.string.snackbar_message_unauthorize))
    }

    /**
     * Shows a snackbar with an error message.
     *
     * @param errorMessage
     *          the message to display
     *
     */
    private fun showErrorSnackbar(errorMessage: String) {

        var contentView = activity.findViewById<View>(R.id.layout_root)

        if (contentView == null) {
            // As a fallback load the Activity root view
            contentView = activity.findViewById(android.R.id.content)
        }
        if (contentView != null) {
            Snackbar.make(contentView, errorMessage, Snackbar.LENGTH_SHORT).show()
        }
    }

}