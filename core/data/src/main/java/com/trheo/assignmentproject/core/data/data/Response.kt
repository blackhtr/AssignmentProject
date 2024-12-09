package com.trheo.assignmentproject.core.data.data

data class PixabayResponse(
    val hits: List<Hit>
)
data class Hit(
    val user: String,                 // 작성자
    val tags: String,                 // 태그
    val imageWidth: Int,              // 이미지 너비
    val imageHeight: Int,             // 이미지 높이
    val views: Int,                   // 조회수
    val downloads: Int,               // 다운로드 수
    val largeImageURL: String         // 이미지 URL
)


data class WikiResponse(
    val pages: List<WikiPage>
)
data class WikiPage(
    val title: String,                // 페이지 제목
    val extract: String,              // 페이지 요약
    val titles: WikiTitles,           // 재검색 키워드
    val originalimage: OriginalImage?, // 이미지 (없을 수도 있음)
    val content_urls: ContentUrls     // 웹뷰 URL
)
data class WikiTitles(
    val canonical: String             // 재검색 키워드
)
data class OriginalImage(
    val source: String                // 이미지 URL
)
data class ContentUrls(
    val mobile: MobileContent         // 모바일 URL
)
data class MobileContent(
    val page: String                  // 웹뷰 URL
)