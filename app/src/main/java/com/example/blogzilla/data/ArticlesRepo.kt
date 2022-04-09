package com.example.blogzilla.data

import io.realworld.api.ConduitClient

object ArticlesRepo {

    val api= ConduitClient().publicApi
    val authApi=ConduitClient().AuthApi

    suspend fun getGlobalFeed()= api.getArticles().body()?.articles

    suspend fun getMyFeed()= authApi.getFeedArticles().body()?.articles
}