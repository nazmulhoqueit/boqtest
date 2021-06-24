package com.example.boqtest.presentation.components

import androidx.annotation.StringRes
/**
 * Provides methods to retrieve resource values.
 *
 * @author nazmul
 */
interface ResourcesComponent {
    fun getString(@StringRes resId: Int, vararg params: Any): String
}