package com.trheo.assignmentproject.core.data.service

import com.trheo.assignmentproject.core.data.data.PixabayResponse
import com.trheo.assignmentproject.core.data.data.WikiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PixabayApi {
    @GET("/api/")
    suspend fun getImages(
        @Query("key") apiKey: String = "36470409-07138ac710797ad8b9bb7dbf9",
        @Query("image_type") imageType: String = "photo",
        @Query("q") query: String,
        @Query("page") page: Int
    ): PixabayResponse
}


interface WikiApi {
    @GET("/api/rest_v1/page/related/{query}")
    suspend fun getRelatedPages(@Path("query") query: String): WikiResponse
}
