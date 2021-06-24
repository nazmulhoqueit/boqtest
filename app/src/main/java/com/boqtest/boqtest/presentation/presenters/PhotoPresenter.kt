package com.example.boqtest.presentation.presenters

import android.content.Context
import com.boqtest.boqtest.domain.models.Photo
import com.example.boqtest.domain.exceptions.NoConnectivityException
import com.example.boqtest.domain.exceptions.UnauthorizedAccessException
import com.example.boqtest.domain.usecases.PhotoUseCase
import com.example.boqtest.presentation.components.ErrorComponent
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class PhotoPresenter @Inject constructor(private val photoUseCase: PhotoUseCase, private val errorComponent: ErrorComponent) {

    private lateinit var view: ViewSurface
    private lateinit var context: Context
    private var photoDisposable: Disposable? = null
    private var isLoading: Boolean = true
    private var page = 1
    private var maxPage: Int = 1
    //region Lifecycle

    fun onCreate(view: ViewSurface, context: Context) {
        this.view = view
        this.context = context
        fetchPhotoCollection(false)
    }

    private fun fetchPhotoCollection(isNotify: Boolean) {

        if (isLoading) {
            view.showLoadingState(true)
        }

        photoDisposable = photoUseCase.getFlickrPhotos(page)
            .doFinally {
                isLoading = false
                view.showLoadingState(false)
                view.showMoreLoadingState(false);
            }
            .subscribe({
                maxPage = it.photos.pages
                view.updatePhotoCollection(it.photos.photo, isNotify)
            },
                {
                    when (it) {
                        is UnauthorizedAccessException -> {
                            errorComponent.handleError(it)
                        }
                        is NoConnectivityException -> {
                            if (isLoading) view.showNetworkError(true)
                            else errorComponent.handleError(it)
                        }
                        else -> {
                            if (isLoading) view.showServerError(true)
                            else errorComponent.handleError(it)
                        }
                    }
                })
    }

    fun loadMore() {
        page++;
        view.showMoreLoadingState(true);
        if (page <= maxPage) {
            fetchPhotoCollection(true)
        }
    }

    fun onRefreshClick() {
        page = 1;
        isLoading = true
        view.showNetworkError(false)
        view.showServerError(false)
        fetchPhotoCollection(false)
    }

    //endregion

    interface ViewSurface {
        fun showLoadingState(show: Boolean)
        fun showNetworkError(show: Boolean)
        fun showServerError(show: Boolean)
        fun updatePhotoCollection(photoCollection: List<Photo>, isNotify: Boolean)
        fun showMoreLoadingState(show: Boolean)
    }
}