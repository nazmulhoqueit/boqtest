package com.example.boqtest.injection.modules

import com.example.boqtest.data.sources.mapper.flickrcom.FlickrClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ClientModule {

    @Provides
    @Singleton
    fun providePriceClient():
            FlickrClient = FlickrClient()
}