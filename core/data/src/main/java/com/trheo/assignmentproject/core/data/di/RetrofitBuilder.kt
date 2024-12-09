package com.trheo.assignmentproject.core.data.di

import com.trheo.assignmentproject.core.data.service.PixabayApi
import com.trheo.assignmentproject.core.data.service.WikiApi
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitBuilder {
    private const val PIXABAY_BASE_URL = "https://pixabay.com/"
    private const val WIKI_BASE_URL = "https://en.wikipedia.org/"

    fun providePixabayApi(): PixabayApi {
        return Retrofit.Builder()
            .baseUrl(PIXABAY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PixabayApi::class.java)
    }

    fun provideWikiApi(): WikiApi {
        return Retrofit.Builder()
            .baseUrl(WIKI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WikiApi::class.java)
    }
}