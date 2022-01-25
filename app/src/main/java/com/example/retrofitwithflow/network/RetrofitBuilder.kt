package com.example.retrofitwithflow.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BaseUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    //Server pr request kari data fetch karavano chhe
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}