package com.trheo.assignmentproject.core.domain.entity
data class SearchResultInfo(
    val title: String,
    val imageUrl: String?,
    val description: String,
    val tags: List<String>,
    val sourceUrl: String
)