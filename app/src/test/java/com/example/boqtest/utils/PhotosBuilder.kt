package com.example.boqtest.utils

import com.boqtest.boqtest.domain.models.Photo
import com.boqtest.boqtest.domain.models.Photos

class PhotosBuilder {
    val page: Int = 1
    val pages: Int = 133
    val perpage: Int = 100
    val total: Int = 13300
    val photo: List<Photo> = emptyList<Photo>().toMutableList()
    fun build(): Photos =
        Photos(
            page = page,
            pages = pages,
            perpage = perpage,
            total = total,
            photo = photo
        )
}
