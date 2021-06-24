package com.boqtest.boqtest.domain.models

data class Photo(val id: String,
                        val owner: String = "",
                        val secret: String = "",
                        val server: String = "",
                        val farm: Int=0,
                        val title: String = "",
                        val ispublic: Int = 0,
                        val isfriend: Int = 0,
                        val isfamily: Int = 0)
