package com.trheo.assignmentproject.wiki

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object SearchResult : Screen("search_result")
    object WikiDetail : Screen("wiki_detail/{title}/{description}/{imageUrl}/{sourceUrl}") {
        fun createRoute(title: String, description: String, imageUrl: String?, sourceUrl: String) =
            "wiki_detail/$title/$description/${imageUrl ?: ""}/$sourceUrl"
    }
    object ImageDetail : Screen("image_detail/{user}/{tags}/{width}/{height}/{views}/{downloads}/{imageUrl}") {
        fun createRoute(user: String, tags: String, width: Int, height: Int, views: Int, downloads: Int, imageUrl: String) =
            "image_detail/$user/$tags/$width/$height/$views/$downloads/$imageUrl"
    }
}