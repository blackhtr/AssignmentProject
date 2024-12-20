package com.trheo.assignmentproject.wiki.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo
import com.trheo.assignmentproject.core.domain.entity.WikiResultInfo
import com.trheo.assignmentproject.wiki.viewmodel.SearchViewModel
import kotlinx.coroutines.flow.filter


@Composable
fun SearchResultScreen(
    query: String,
    onImageClick: (ImageResultInfo) -> Unit,
    onWikiClick: (WikiResultInfo) -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val imageResults by viewModel.imageResults.collectAsState()
    val wikiResults by viewModel.wikiResults.collectAsState()
    val scrollState = rememberLazyListState()

    // 스크롤이 끝에 도달했을 때 추가 이미지 로드
    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .filter { it == imageResults.size - 1 } // 마지막 아이템이 보일 때
            .collect {
                val query = viewModel.query.value
                if (query.isNotEmpty()) { viewModel.loadMoreImages(query) }
            }
    }

    LaunchedEffect(query) {
        viewModel.updateQuery(query)
    }

    LazyColumn(state = scrollState) {
        // 검색어 표시
        item {
            Text(
                text = "\"$query\" 검색 결과입니다.",
                modifier = Modifier.padding(16.dp)
            )
        }

        // 첫 번째 이미지 결과 표시
        if (imageResults.isNotEmpty()) {
            item {
                FirstImageItem(
                    imageResult = imageResults.first(),
                    onClick = { onImageClick(imageResults.first()) }
                )
            }
        }

        // Wiki 결과 표시
        if (wikiResults.isNotEmpty()) {
            item {
                Text(
                    text = "Wiki 검색 결과",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    wikiResults.forEach { wiki ->
                        WikiItem(wikiResult = wiki, onClick = { onWikiClick(wiki) })
                    }
                }
            }
        }

        // 나머지 이미지 결과 표시
        if (imageResults.size > 1) {
            items(imageResults.drop(1)) { image ->
                ImageListItem(imageResult = image, onClick = { onImageClick(image) })
            }
        }
    }
}


