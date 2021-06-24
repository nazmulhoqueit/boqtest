package com.example.boqtest.presentation.presenters

import android.content.Context
import com.example.boqtest.domain.exceptions.NoConnectivityException
import com.example.boqtest.domain.exceptions.UnexpectedServerException
import com.example.boqtest.domain.usecases.PhotoUseCase
import com.example.boqtest.presentation.components.ErrorComponent
import com.example.boqtest.utils.PhotoResponseBuilder
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * @author nazmul
 */

class PhotoPresenterTest {

    lateinit var presenter: PhotoPresenter
    lateinit var mockView: PhotoPresenter.ViewSurface
    lateinit var photoUseCase: PhotoUseCase
    lateinit var mockContext: Context
    lateinit var errorComponent: ErrorComponent

    @Before
    fun setup() {
        photoUseCase = Mockito.mock(PhotoUseCase::class.java)
        errorComponent = Mockito.mock(ErrorComponent::class.java)
        presenter =
            PhotoPresenter(photoUseCase, errorComponent)
        mockView = Mockito.mock(PhotoPresenter.ViewSurface::class.java)
        mockContext = Mockito.mock(Context::class.java)
    }

    @Test
    fun onCreate_PhotoCollection_updatePhotoCollection() {
        //Arrange

        Mockito.`when`(photoUseCase.getFlickrPhotos(1)).thenReturn(Single.just(PhotoResponseBuilder().build()))

        // Act
        presenter.onCreate(mockView, mockContext)

        // Assert
        Mockito.verify(mockView).showLoadingState(false)
        Mockito.verify(mockView, Mockito.atLeast(1)).showLoadingState(false)
        Mockito.verify(mockView, Mockito.atLeast(1)).updatePhotoCollection(PhotoResponseBuilder().build().photos.photo,false)
    }
    @Test
    fun onCreate_networkErrorOnPhotoCollectiontFetch_showInlineNetworkError() {
        //Arrange
        Mockito.`when`(photoUseCase.getFlickrPhotos(1)).thenReturn(
            Single.error(
            NoConnectivityException()
        ))

        // Act
        presenter.onCreate(mockView, mockContext)

        // Assert
        Mockito.verify(mockView).showLoadingState(true)
        Mockito.verify(mockView).showNetworkError(true)
        Mockito.verify(mockView).showLoadingState(false)
    }

    @Test
    fun onCreate_serverErrorOnPhotoCollectiontFetch_showInlineServerError() {
        // Arrange
        Mockito.`when`(photoUseCase.getFlickrPhotos(1)).thenReturn(Single.error(
            UnexpectedServerException()
        ))

        // Act
        presenter.onCreate(mockView, mockContext)

        // Assert
        Mockito.verify(mockView).showLoadingState(true)
        Mockito.verify(mockView).showServerError(true)
        Mockito.verify(mockView).showLoadingState(false)
    }
}