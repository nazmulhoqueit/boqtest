package com.example.boqtest

import android.app.Application
import com.boqtest.boqtest.injection.components.ApplicationComponent
import com.boqtest.boqtest.injection.components.DaggerApplicationComponent
import com.example.boqtest.injection.modules.ApplicationModule
import io.reactivex.internal.functions.Functions
import io.reactivex.plugins.RxJavaPlugins

class Application : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initApplicationComponent()
        // Configure RxJava to not crash the app when errors cannot be emitted
        RxJavaPlugins.setErrorHandler(Functions.emptyConsumer())
    }

    //region Private
    private fun initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
    //endregion
}