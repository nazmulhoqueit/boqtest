package com.example.boqtest.data.sources.mapper.flickrcom

import com.boqtest.boqtest.domain.models.PhotoResponse
import com.example.boqtest.Configuration
import com.example.boqtest.data.sources.mapper.FlickrcomApiDomainExceptionMapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class FlickrClient @Inject constructor() {

    private val READ_TIMEOUT_SECONDS: Long = 30
    private var service: FlickrService

    init {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)

        val retrofit = Retrofit.Builder()
            .baseUrl(Configuration.flickrBaseUrl)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
        service = retrofit.create(FlickrService::class.java)
    }

    fun getFlickrPhotos(page: Int): Single<PhotoResponse> {
        return service.getFlickrPhotos(Configuration.api_key, page)
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorResumeNext { throwable ->
                Single.error(FlickrcomApiDomainExceptionMapper.map(throwable))
            }
    }
}