package com.trheo.core.domain.repository

import com.trheo.assignmentproject.core.domain.entity.SearchResultInfo

interface SearchRepository {
    suspend fun searchImages(query: String, page: Int): List<SearchResultInfo>
    suspend fun searchWiki(query: String): List<SearchResultInfo>
}