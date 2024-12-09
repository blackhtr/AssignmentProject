package com.trheo.assignmentproject.wiki.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo


@Composable
fun FirstImageItem(imageResult: ImageResultInfo, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = MaterialTheme.shapes.medium
            )
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = imageResult.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(end = 16.dp)
        )
        Column {
            Text(text = "작성자: ${imageResult.user}")
            Text(text = "태그: ${imageResult.tags}")
            Text(
                text = "사이즈: ${imageResult.width} x ${imageResult.height}",
            )
            Text(text = "조회수: ${imageResult.views}")
            Text(text = "다운로드: ${imageResult.downloads}")
        }
    }
}


@Composable
fun ImageListItem(imageResult: ImageResultInfo, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = MaterialTheme.shapes.medium
            ),
        verticalAlignment = Alignment.CenterVertically // 높이 가운데 정렬

    ) {
        AsyncImage(
            model = imageResult.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 16.dp)
        )
        Column {
            Text(text = "태그: ${imageResult.tags}")
            Text(
                text = "사이즈: ${imageResult.width} x ${imageResult.height}"
            )
        }
    }
}

