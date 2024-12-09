package com.trheo.assignmentproject.wiki.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo

@Composable
fun ImageDetailScreen(
    info:ImageResultInfo,
    onTagClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "작성자 : ${info.user}",
            modifier = Modifier.padding(bottom = 8.dp))
        Row(
            modifier = Modifier.padding(bottom = 8.dp),
        ) {
            Text(text = "태그 : ")
            info.tags.split(", ").forEach { tag ->
                Text(text = "#$tag",
                    modifier = Modifier.clickable { onTagClick(tag) })
            }
        }
        Text(text = "사이즈 : ${info.width} x ${info.height}",
            modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "조회 : ${info.views}",
            modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "다운로드 : ${info.downloads}",
            modifier = Modifier.padding(bottom = 8.dp))
        AsyncImage(model = info.imageUrl, contentDescription = null)
    }
}