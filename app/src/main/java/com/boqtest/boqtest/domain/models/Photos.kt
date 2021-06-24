package com.boqtest.boqtest.domain.models

data class Photos(val page: Int = 0, val pages: Int = 0,
                 val perpage: Int = 0,
                 val total: Int = 0,
                 val photo: List<Photo>)
