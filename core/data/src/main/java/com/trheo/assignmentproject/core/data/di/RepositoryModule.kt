package com.trheo.bookesearcher.di

import com.trheo.assignmentproject.core.data.SearchRepositoryImpl
import com.trheo.assignmentproject.core.data.service.PixabayApi
import com.trheo.assignmentproject.core.data.service.WikiApi
import com.trheo.core.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideSearchRepository(pixabayApi: PixabayApi, wikiApi: WikiApi): SearchRepository {
        return SearchRepositoryImpl(pixabayApi, wikiApi)
    }
}