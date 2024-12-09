package com.trheo.assignmentproject.wiki.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trheo.assignmentproject.core.domain.entity.WikiResultInfo

@Composable
fun WikiDetailScreen(
    info:WikiResultInfo,
    onKeywordClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // 타이틀
        Text(
            text = info.title,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 이미지 (옵션)
        info.imageUrl?.let {
            AsyncImage(
                model = it,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 8.dp)
            )
        }

        // 상세 정보
        Text(
            text = info.description,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 키워드 (재검색)
        Text(
            text = "키워드: ${info.keyword}",
            modifier = Modifier
                .clickable { onKeywordClick(info.keyword) }
                .padding(vertical = 8.dp)
        )

        // 웹뷰로 이동 버튼
        Button(
            onClick = { /* Launch WebView */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("출처 보기")
        }
    }
}