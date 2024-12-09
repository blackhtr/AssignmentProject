package com.trheo.assignmentproject.wiki

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trheo.assignmentproject.core.domain.entity.SearchResultInfo
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

    private val _state = MutableStateFlow(SearchUiState())
    val state: StateFlow<SearchUiState> = _state

    fun search(query: String) {
        viewModelScope.launch {
            val images = searchRepository.searchImages(query, 1)
            val wiki = searchRepository.searchWiki(query)
            _state.value = _state.value.copy(results = images + wiki)
        }
    }
}

data class SearchUiState(
    val query: String = "",
    val results: List<SearchResultInfo> = emptyList()
)