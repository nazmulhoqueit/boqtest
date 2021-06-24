package com.boqtest.boqtest.injection.components

import android.content.Context
import com.example.boqtest.Application
import com.example.boqtest.domain.repositories.PhotoRepository
import com.example.boqtest.injection.modules.ApplicationModule
import com.example.boqtest.injection.modules.ClientModule
import com.example.boqtest.injection.modules.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    ApplicationModule::class, RepositoryModule::class,
    ClientModule::class))
interface ApplicationComponent {

    val context: Context

    fun inject(application: Application)

    fun providePhotoRepository(): PhotoRepository
}