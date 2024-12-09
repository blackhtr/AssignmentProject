package com.trheo.assignmentproject.wiki.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trheo.assignmentproject.core.domain.entity.SearchResultInfo

@Composable
fun SearchResultScreen(
    searchResults: List<SearchResultInfo>,
    onImageClick: (SearchResultInfo) -> Unit,
    onWikiClick: (SearchResultInfo) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        itemsIndexed(searchResults) { index, result ->
            when {
                index == 1 && result.tags.contains("wiki") -> {
                    WikiItem(result, onClick = { onWikiClick(result) })
                }
                else -> {
                    ImageItem(result, onClick = { onImageClick(result) })
                }
            }
        }
    }
}


@Composable
fun WikiItem(
    wikiResult: SearchResultInfo,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        // 이미지 (없으면 No Image 표시)
        if (wikiResult.imageUrl != null) {
            AsyncImage(
                model = wikiResult.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        } else {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("No Image")
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // 텍스트 (타이틀)
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = wikiResult.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = wikiResult.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun ImageItem(
    imageResult: SearchResultInfo,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        // 이미지
        AsyncImage(
            model = imageResult.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 작성자
        Text(
            text = "작성자: ${imageResult.title}"
        )

        Spacer(modifier = Modifier.height(4.dp))

        // 태그, 크기, 조회수, 다운로드 수
        Text(
            text = "태그: ${imageResult.tags.joinToString(", ")}",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "크기: ${imageResult.description}"
        )
    }
}
