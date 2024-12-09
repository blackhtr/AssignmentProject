package com.trheo.assignmentproject.wiki.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo

@Composable
fun ImageDetailScreen(
    info:ImageResultInfo
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Title: ${info.user}")
        Text(text = "Tags: ${info.tags}")
        Text(text = "Size: ${info.width} x ${info.height}")
        Text(text = "Views: ${info.views}")
        Text(text = "Downloads: ${info.downloads}")
        AsyncImage(model = info.imageUrl, contentDescription = null)
    }
}