package com.example.boqtest.domain.usecase

import com.example.boqtest.domain.repositories.PhotoRepository
import com.example.boqtest.domain.usecases.PhotoUseCase
import com.example.boqtest.utils.PhotoResponseBuilder
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * @author nazmul
 */

class PhotoUseCaseTest {

    lateinit var photoUseCase: PhotoUseCase
    lateinit var photoRepository: PhotoRepository

    @Before
    fun setup() {
        photoRepository = Mockito.mock(PhotoRepository::class.java)
        photoUseCase = PhotoUseCase(photoRepository)
    }

    @Test
    fun fetch_getPhotosByPage() {
        // Arrange
        Mockito.`when`(photoRepository.getFlickrPhotos(1))
            .thenReturn(
                Single.just(
                PhotoResponseBuilder().build()))

        // Act
        photoUseCase.getFlickrPhotos(1)!!.subscribe({}, {})

        // Assert
        Mockito.verify(photoRepository).getFlickrPhotos(1)
    }

    @Test
    fun fetch_getPhotosByPage_never() {
        // Arrange
        Mockito.`when`(photoRepository.getFlickrPhotos(1))
            .thenReturn(Single.just(
                PhotoResponseBuilder().build()))

        // Act
        photoUseCase.getFlickrPhotos(1)!!.subscribe({}, {})

        // Assert
        Mockito.verify(photoRepository, Mockito.never()).getFlickrPhotos(2)
    }
}