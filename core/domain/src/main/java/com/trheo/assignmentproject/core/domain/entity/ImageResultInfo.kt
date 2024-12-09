package com.trheo.assignmentproject.core.domain.entity
data class ImageResultInfo(
    val user: String,
    val tags: String,
    val width: Int,
    val height: Int,
    val views: Int,
    val downloads: Int,
    val imageUrl: String
)