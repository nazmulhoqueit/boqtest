package com.example.boqtest.utils

import com.boqtest.boqtest.domain.models.Photo

class PhotoBuilder {
    val id: String = "213"
    val owner: String = "2131"
    val secret: String = "321313"
    val server: String = "131313"
    val farm: Int = 0
    val title: String = "FLickr Photo 1"
    val ispublic: Int = 0
    val isfriend: Int = 0
    val isfamily: Int = 0

    fun build(): Photo =
        Photo(
            id =id,
            owner = owner,
            secret = secret,
            server = server,
            farm = farm,
            title = title,
            ispublic = ispublic,
            isfriend = isfriend,
            isfamily = isfamily
    )
}