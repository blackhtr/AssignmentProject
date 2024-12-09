package com.trheo.assignmentproject.wiki.ui

import android.webkit.WebView
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
import androidx.compose.ui.viewinterop.AndroidView
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

        // 키워드 (재검색)
        Text(
            text = "키워드 : #${info.keyword}",
            modifier = Modifier
                .clickable { onKeywordClick(info.keyword) }
                .padding(vertical = 8.dp)
        )

        Text(
            text = "타이틀 : ${info.title}",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 상세 정보
        Text(
            text = "상세정보 : ${info.description}",
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





        if(info.webViewUrl.isNotBlank()){
            AndroidView(
                factory = { context ->
                    WebView(context).apply {
                        settings.javaScriptEnabled = true // JavaScript 활성화
                        settings.domStorageEnabled = true // DOM Storage 활성화
                        settings.loadWithOverviewMode = true // 웹 콘텐츠 화면 크기에 맞춤
                        settings.useWideViewPort = true // 화면 폭에 맞게 콘텐츠 표시
                        loadUrl(info.webViewUrl) // URL 로드
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}