package com.example.boqtest.domain.repositories

import com.boqtest.boqtest.domain.models.PhotoResponse
import io.reactivex.Single

interface PhotoRepository {
    fun getFlickrPhotos(page: Int): Single<PhotoResponse>
}