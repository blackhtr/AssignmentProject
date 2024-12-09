package com.trheo.assignmentproject.wiki.viewmodel

import androidx.lifecycle.ViewModel
import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo
import com.trheo.assignmentproject.core.domain.entity.WikiResultInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {
    private val _imageDetail = MutableStateFlow<ImageResultInfo?>(null)
    val imageDetail: StateFlow<ImageResultInfo?> = _imageDetail
    fun setImageDetail(detail: ImageResultInfo) {
        _imageDetail.value = detail
    }
    private val _wikiDetail = MutableStateFlow<WikiResultInfo?>(null)
    val wikiDetail: StateFlow<WikiResultInfo?> = _wikiDetail

    fun setWikiDetail(detail: WikiResultInfo) {
        _wikiDetail.value = detail
    }
}