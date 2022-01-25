package com.example.retrofitwithflow.repository

import com.example.retrofitwithflow.model.Post
import com.example.retrofitwithflow.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository() {
    companion object {
        fun getPost(): Flow<List<Post>> = flow {
            val response = RetrofitBuilder.apiService.getPost()
            emit(response)  //1 by 1 in sequence it'll emit data to the Collector
        }.flowOn(Dispatchers.IO)    //to do upStream (upper no code) in background
    }
}