package com.trheo.assignmentproject.wiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo
import com.trheo.assignmentproject.core.domain.entity.SearchResultInfo
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
    private val _imageResults = MutableStateFlow<List<ImageResultInfo>>(emptyList())
    val imageResults: StateFlow<List<ImageResultInfo>> = _imageResults

    private val _wikiResults = MutableStateFlow<List<WikiResultInfo>>(emptyList())
    val wikiResults: StateFlow<List<WikiResultInfo>> = _wikiResults

    private var currentPage = 1

    fun search(query: String) {
        viewModelScope.launch {
            val images = searchRepository.searchImages(query, currentPage)
            val wiki = searchRepository.searchWiki(query)
            _imageResults.value = _imageResults.value + images
            _wikiResults.value = wiki.take(3) // 최대 3개 제한
        }
    }

    fun loadMoreImages(query: String) {
        viewModelScope.launch {
            currentPage++
            val moreImages = searchRepository.searchImages(query, currentPage)
            _imageResults.value = _imageResults.value + moreImages
        }
    }
}

data class SearchUiState(
    val query: String = "",
    val results: List<SearchResultInfo> = emptyList()
)