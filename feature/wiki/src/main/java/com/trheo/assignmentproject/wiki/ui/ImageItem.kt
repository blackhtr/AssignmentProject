package com.trheo.assignmentproject.wiki.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trheo.assignmentproject.core.domain.entity.ImageResultInfo


@Composable
fun FirstImageItem(imageResult: ImageResultInfo, onClick: () -> Unit) {
    var expanded by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
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
                if (expanded) {
                    // 확장 시에만 추가 정보 표시
                    Text(text = "조회수: ${imageResult.views}")
                    Text(text = "다운로드: ${imageResult.downloads}")
                }
            }
        }
        Button(
            onClick = { expanded = !expanded }, // 버튼 클릭 시 상태 전환
            modifier = Modifier
                .height(32.dp)
                .width(80.dp)
                .align(Alignment.End),
            contentPadding = PaddingValues(4.dp)
        ) {
            Text(text = if (expanded) "줄이기" else "펼치기")
        }
    }

}


@Composable
fun ImageListItem(imageResult: ImageResultInfo, onClick: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onClick() },
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
                if (expanded) {
                    // 확장 시에만 추가 정보 표시
                    Text(text = "조회수: ${imageResult.views}")
                    Text(text = "다운로드: ${imageResult.downloads}")
                }
            }
        }
        Button(
            onClick = { expanded = !expanded },
            modifier = Modifier
                .height(32.dp)
                .width(80.dp).align(Alignment.End),
            contentPadding = PaddingValues(4.dp)
        ) {
            Text(text = if (expanded) "줄이기" else "펼치기")
        }
    }

}

