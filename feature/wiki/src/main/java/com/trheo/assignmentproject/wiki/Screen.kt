package com.trheo.assignmentproject.wiki

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object SearchResult : Screen("search_result?query={query}") {
        fun createRoute(query: String) = "search_result?query=$query"
    }
    object WikiDetail : Screen("wiki_detail") // 데이터는 ViewModel로 전달
    object ImageDetail : Screen("image_detail") // 데이터는 ViewModel로 전달
}