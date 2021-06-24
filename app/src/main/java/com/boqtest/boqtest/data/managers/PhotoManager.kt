package com.example.boqtest.data.managers

import com.boqtest.boqtest.domain.models.PhotoResponse
import com.example.boqtest.data.sources.mapper.flickrcom.FlickrClient
import com.example.boqtest.domain.repositories.PhotoRepository
import io.reactivex.Single

class PhotoManager(private var flickrClient: FlickrClient) : PhotoRepository {

    override fun getFlickrPhotos(page: Int): Single<PhotoResponse> {
        return flickrClient.getFlickrPhotos(page)
            .flatMap { response: PhotoResponse ->
                Single.just(response)
            }
    }
}
