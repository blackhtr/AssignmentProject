package com.trheo.core.domain.usecase

import com.trheo.assignmentproject.core.domain.entity.SearchResultInfo
import com.trheo.core.domain.repository.SearchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend fun searchImages(query: String, page: Int): List<SearchResultInfo> = searchRepository.searchImages(query, page)
    suspend fun searchWiki(query: String): List<SearchResultInfo> = searchRepository.searchWiki(query)
}