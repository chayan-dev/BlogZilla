package com.example.blogzilla.ui.feed

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogzilla.data.ArticlesRepo
import io.realworld.api.models.entities.Article
import kotlinx.coroutines.launch

class FeedViewModel: ViewModel() {

    private val _feed = MutableLiveData<List<Article>>()

    val feed: LiveData<List<Article>> = _feed

    fun fetchGlobalFeed()= viewModelScope.launch {
        ArticlesRepo.getGlobalFeed()?.let {
            _feed.postValue(it)
        }
    }

    fun fetchMyFeed()= viewModelScope.launch {
        ArticlesRepo.getMyFeed()?.let {
            _feed.postValue(it)

        }

    }
}