package com.trheo.assignmentproject.core.data

import com.trheo.assignmentproject.core.data.service.PixabayApi
import com.trheo.assignmentproject.core.data.service.WikiApi
import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo
import com.trheo.assignmentproject.core.domain.entity.WikiResultInfo
import com.trheo.core.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val pixabayApi: PixabayApi,
    private val wikiApi: WikiApi
) : SearchRepository {
    // 위키 검색
    override suspend fun searchWiki(query: String): List<WikiResultInfo> {
        return try {
            val response = wikiApi.getRelatedPages(query)
            response.pages.map { page ->
                WikiResultInfo(
                    title = page.title,
                    keyword = page.titles.canonical,
                    description = page.extract,
                    imageUrl = page.originalimage?.source,
                    webViewUrl = page.content_urls.mobile.page
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
    // 이미지 검색
    override suspend fun searchImages(query: String, page: Int): List<ImageResultInfo> {
        return try {
            val response = pixabayApi.getImages(query = query, page = page)
            response.hits.map { hit ->
                ImageResultInfo(
                    user = hit.user,
                    tags = hit.tags,
                    width = hit.imageWidth,
                    height = hit.imageHeight,
                    views = hit.views,
                    downloads = hit.downloads,
                    imageUrl = hit.largeImageURL
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}