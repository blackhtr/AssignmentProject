package com.trheo.core.domain.usecase

import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo
import com.trheo.assignmentproject.core.domain.entity.SearchResultInfo
import com.trheo.assignmentproject.core.domain.entity.WikiResultInfo
import com.trheo.core.domain.repository.SearchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend fun searchImages(query: String, page: Int): List<ImageResultInfo> = searchRepository.searchImages(query, page)
    suspend fun searchWiki(query: String): List<WikiResultInfo> = searchRepository.searchWiki(query)
}