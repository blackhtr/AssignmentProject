package com.trheo.assignmentproject.wiki.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trheo.assignmentproject.core.domain.entity.WikiResultInfo

@Composable
fun WikiItem(wikiResult: WikiResultInfo, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .padding(8.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
            )
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (wikiResult.imageUrl != null) {
            AsyncImage(
                model = wikiResult.imageUrl,
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        } else {
            Box(
                modifier = Modifier
                    .size(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("No Image")
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = wikiResult.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
