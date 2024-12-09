package com.trheo.assignmentproject.core.data

import com.trheo.assignmentproject.core.data.service.PixabayApi
import com.trheo.assignmentproject.core.data.service.WikiApi
import com.trheo.assignmentproject.core.domain.entity.SearchResultInfo
import com.trheo.core.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val pixabayApi: PixabayApi,
    private val wikiApi: WikiApi
) : SearchRepository {
    override suspend fun searchImages(query: String, page: Int): List<SearchResultInfo> {
        val response = pixabayApi.getImages(query = query, page = page)
        return response.hits.map {
            SearchResultInfo(
                title = it.user,
                imageUrl = it.largeImageURL,
                description = "Size: ${it.imageWidth}x${it.imageHeight}",
                tags = it.tags.split(", "),
                sourceUrl = ""
            )
        }
    }

    override suspend fun searchWiki(query: String): List<SearchResultInfo> {
        val response = wikiApi.getRelatedPages(query)
        return response.pages.map {
            SearchResultInfo(
                title = it.title,
                imageUrl = it.originalimage?.source,
                description = it.extract,
                tags = listOf(it.titles.canonical),
                sourceUrl = it.content_urls.mobile.page
            )
        }
    }
}