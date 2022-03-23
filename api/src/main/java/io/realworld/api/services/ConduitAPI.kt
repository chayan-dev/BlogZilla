package io.realworld.api.services

import io.realworld.api.models.requests.LoginRequest
import io.realworld.api.models.requests.SignupRequest
import io.realworld.api.models.responses.ArticlesResponse
import io.realworld.api.models.responses.TagsResponse
import io.realworld.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAPI {

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author:String?=null,
        @Query("favourited") favourited:String?=null,
        @Query("tag") tags:List<String>?=null
    ): Response<ArticlesResponse>

    @POST("users")
    suspend fun signupUser(
        @Body userCreds: SignupRequest
    ): Response<UserResponse>

    @POST("users")
    suspend fun loginUser(
        @Body userCreds: LoginRequest
    ): Response<UserResponse>

    @GET
    suspend fun getArticleBySlug(
        @Path("slug") slug:String
    ): Response<ArticlesResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>

}