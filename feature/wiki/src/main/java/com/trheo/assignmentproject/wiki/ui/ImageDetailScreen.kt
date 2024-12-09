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

@Composable
fun ImageDetailScreen(
    user: String,
    tags: List<String>,
    size: Pair<Int, Int>,
    views: Int,
    downloads: Int,
    imageUrl: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // 이미지
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp)
        )

        // 작성자
        Text(
            text = "작성자: $user",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 태그
        Text(
            text = "태그: ${tags.joinToString(", ")}",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 사이즈
        Text(
            text = "사이즈: ${size.first} x ${size.second}",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 조회수
        Text(
            text = "조회수: $views 회",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 다운로드 수
        Text(
            text = "다운로드: $downloads 회",
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}
