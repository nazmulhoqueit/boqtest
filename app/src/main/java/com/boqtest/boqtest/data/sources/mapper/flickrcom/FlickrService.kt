package com.example.boqtest.data.sources.mapper.flickrcom

import com.boqtest.boqtest.domain.models.PhotoResponse
import io.reactivex.Single
import retrofit2.http.*

/**
 * Defines the list of operations available on the Flickr service.
 *
 * @author nazmul
 */

interface FlickrService {

    @GET("services/rest/?method=flickr.photos.search&text=kittens&format=json&nojsoncallback=1")
    fun getFlickrPhotos(@Query("api_key") api_key: String, @Query("page") page: Int): Single<PhotoResponse>
}