package com.trheo.bookesearcher.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /*@Provides
    @Singleton
    fun provideSearchRepository(apiService: GoogleBooksApi): SearchRepository {
        return SearchRepositoryImpl(apiService)
    }*/
}