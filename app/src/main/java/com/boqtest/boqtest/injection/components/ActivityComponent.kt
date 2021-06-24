package com.example.boqtest.injection.components

import com.boqtest.boqtest.injection.components.ApplicationComponent
import com.boqtest.boqtest.presentation.activities.SplashActivity
import com.example.boqtest.injection.annotation.PerScreen
import com.example.boqtest.injection.modules.ActivityModule
import com.example.boqtest.injection.modules.ComponentModule
import com.example.boqtest.presentation.activities.PhotoActivity
import dagger.Component

@PerScreen
@Component(dependencies = arrayOf(ApplicationComponent::class),
    modules = arrayOf(ActivityModule::class, ComponentModule::class))
interface ActivityComponent {

    fun inject(activity: PhotoActivity)
    fun inject(activity: SplashActivity)
}