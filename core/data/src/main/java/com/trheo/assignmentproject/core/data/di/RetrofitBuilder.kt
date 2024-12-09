package com.trheo.assignmentproject.core.data.di

import com.trheo.assignmentproject.core.data.service.PixabayApi
import com.trheo.assignmentproject.core.data.service.WikiApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitBuilder {
    private const val PIXABAY_BASE_URL = "https://pixabay.com/"
    private const val WIKI_BASE_URL = "https://en.wikipedia.org/"
    @Provides
    @Singleton
    fun providePixabayRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(PIXABAY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePixabayApi(retrofit: Retrofit): PixabayApi {
        return retrofit.create(PixabayApi::class.java)
    }
    @Provides
    @Singleton
    fun provideWikiApi(): WikiApi {
        return Retrofit.Builder()
            .baseUrl(WIKI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WikiApi::class.java)
    }
}