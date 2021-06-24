package com.example.boqtest.domain.usecases

import com.boqtest.boqtest.domain.models.PhotoResponse
import com.example.boqtest.domain.repositories.PhotoRepository
import io.reactivex.Single
import javax.inject.Inject

class PhotoUseCase @Inject constructor(private val photoRepository: PhotoRepository) {

    fun getFlickrPhotos(page: Int): Single<PhotoResponse> {
        return photoRepository.getFlickrPhotos(page)
            .flatMap {
                Single.just(it)
            }
    }
}

