package com.trheo.assignmentproject.wiki.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onSearch: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        var query by remember { mutableStateOf(TextFieldValue("")) } // TextFieldValue 초기화
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("검색어를 입력하세요") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onSearch(query.text) }, // TextFieldValue에서 텍스트 추출
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("검색")
        }
    }
}