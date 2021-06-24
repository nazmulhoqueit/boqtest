package com.example.boqtest.presentation.presenters

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * @author nazmul
 */

class SplashPresenterTest {

    lateinit var presenter: SplashPresenter
    lateinit var mockView: SplashPresenter.ViewSurface

    @Before
    fun setup() {
        presenter = SplashPresenter()
        mockView = Mockito.mock(SplashPresenter.ViewSurface::class.java)
    }

    @Test
    fun onNavigateToPhoto() {
        // Arrange

        // Act
        presenter.onCreate(mockView)

        // Assert
        Mockito.verify(mockView).navigateToPhoto()
    }
}