package com.example.boqtest.presentation.components

import android.content.Context
import androidx.annotation.StringRes
/**
 * Provides methods to retrieve resource values.
 *
 * @author nazmul
 */
class ResourcesComponentImpl(val context: Context) : ResourcesComponent {
    override fun getString(@StringRes resId: Int, vararg params: Any): String {
        return context.getString(resId, *params)
    }
}