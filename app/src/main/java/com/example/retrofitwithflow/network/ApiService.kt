package com.example.retrofitwithflow.network

import com.example.retrofitwithflow.model.Post
import retrofit2.http.GET

//Api end points will be mentioned here
interface ApiService {
    @GET("posts")
    suspend fun getPost(): List<Post>   //suspend as this work will be done in the background
}