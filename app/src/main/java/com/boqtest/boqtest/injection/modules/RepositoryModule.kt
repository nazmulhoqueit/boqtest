package com.example.boqtest.injection.modules

import com.example.boqtest.data.managers.PhotoManager
import com.example.boqtest.data.sources.mapper.flickrcom.FlickrClient
import com.example.boqtest.domain.repositories.PhotoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providePhotoRepository(flickrClient:  FlickrClient): PhotoRepository {
        return PhotoManager(flickrClient)
    }
}