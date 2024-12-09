package com.trheo.core.domain.repository

import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo
import com.trheo.assignmentproject.core.domain.entity.SearchResultInfo
import com.trheo.assignmentproject.core.domain.entity.WikiResultInfo

interface SearchRepository {
    suspend fun searchWiki(query: String): List<WikiResultInfo>
    suspend fun searchImages(query: String, page: Int): List<ImageResultInfo>
}