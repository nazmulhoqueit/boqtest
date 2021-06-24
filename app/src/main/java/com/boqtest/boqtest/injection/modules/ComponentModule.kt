package com.example.boqtest.injection.modules

import android.app.Activity
import com.example.boqtest.presentation.components.ErrorComponent
import com.example.boqtest.presentation.components.ErrorComponentImpl
import com.example.boqtest.presentation.components.ResourcesComponent
import com.example.boqtest.presentation.components.ResourcesComponentImpl
import dagger.Module
import dagger.Provides

/**
 * @author nazmul
 */
@Module
class ComponentModule(private val activity: Activity) {

    @Provides
    fun provideErrorComponent():
            ErrorComponent = ErrorComponentImpl(activity)

    @Provides
    fun provideResourcesComponent():
            ResourcesComponent = ResourcesComponentImpl(activity)
}