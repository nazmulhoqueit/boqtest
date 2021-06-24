package com.example.boqtest.presentation.presenters

import javax.inject.Inject

/**
 * @author nazmul
 */
class SplashPresenter @Inject constructor() {

    private lateinit var view: ViewSurface

    //region Lifecycle

    fun onCreate(view: ViewSurface) {
        this.view = view
        navigateToPhoto()
    }

    //region Events

    fun navigateToPhoto() {
        view.navigateToPhoto()
    }

    //endregion

    interface ViewSurface {
        fun navigateToPhoto()
    }
}