package com.trheo.assignmentproject.core.data.service

interface PixabayApi {
    @GET("/api/")
    suspend fun getImages(
        @Query("key") apiKey: String,
        @Query("image_type") imageType: String = "photo",
        @Query("q") query: String,
        @Query("page") page: Int
    ): PixabayResponse
}


interface WikiApi {
    @GET("/api/rest_v1/page/related/{query}")
    suspend fun getRelatedPages(@Path("query") query: String): WikiResponse
}
