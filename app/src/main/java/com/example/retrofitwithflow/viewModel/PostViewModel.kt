package com.example.retrofitwithflow.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithflow.model.Post
import com.example.retrofitwithflow.repository.PostRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    /*livedata*/
    private val _postMutableLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    val postMutableLiveData: LiveData<List<Post>> = _postMutableLiveData

    /*get data to main thread from background*/
    fun getPost() {
        viewModelScope.launch {
            PostRepository.getPost()
                .catch { e->    //to handle error
                    Log.d("VRAJTEST", "getPost: ${e.message}")
                }
                .collect { postList ->
                    _postMutableLiveData.value = postList   //Flow is not lifecycle aware, thats why we need to convert in to livedata
                }
        }
    }
}