package com.trheo.assignmentproject.wiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo
import com.trheo.assignmentproject.core.domain.entity.WikiResultInfo
import com.trheo.core.domain.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val _query = MutableStateFlow("") // 현재 검색어
    val query: StateFlow<String> = _query

    private val _imageResults = MutableStateFlow<List<ImageResultInfo>>(emptyList())
    val imageResults: StateFlow<List<ImageResultInfo>> = _imageResults

    private val _wikiResults = MutableStateFlow<List<WikiResultInfo>>(emptyList())
    val wikiResults: StateFlow<List<WikiResultInfo>> = _wikiResults

    private var currentPage = 1
    private var isFetchingImages = false // 중복 호출 방지

    init {
        viewModelScope.launch {
            _query.collect { searchQuery ->
                if (searchQuery.isNotEmpty()) {
                    performSearch(searchQuery)
                }
            }
        }
    }
     suspend fun performSearch(query: String) {
        currentPage = 1
        val images = searchRepository.searchImages(query, currentPage)
        val wiki = searchRepository.searchWiki(query)

        _imageResults.value = images
        _wikiResults.value = wiki.take(3) // 최대 3개
    }


    fun loadMoreImages(query: String) {
        if (isFetchingImages) return // 중복 호출 방지
        isFetchingImages = true

        viewModelScope.launch {
            currentPage++
            try {
                val moreImages = searchRepository.searchImages(query, currentPage)
                _imageResults.value = _imageResults.value + moreImages
            } catch (e: Exception) {
                // 에러 처리
            } finally {
                isFetchingImages = false
            }
        }
    }

    fun updateQuery(newQuery: String) {
        _query.value = newQuery // 검색어 업데이트
    }
}