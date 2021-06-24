package com.example.boqtest.utils

import com.boqtest.boqtest.domain.models.PhotoResponse
import com.boqtest.boqtest.domain.models.Photos

class PhotoResponseBuilder {
    val photos: Photos = PhotosBuilder().build()

    fun build(): PhotoResponse =
        PhotoResponse(
            photos = photos
        )
}
