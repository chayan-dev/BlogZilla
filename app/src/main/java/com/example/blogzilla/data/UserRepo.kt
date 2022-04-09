package com.example.blogzilla.data

import io.realworld.api.ConduitClient
import io.realworld.api.models.entities.LoginData
import io.realworld.api.models.entities.SignupData
import io.realworld.api.models.entities.User
import io.realworld.api.models.requests.LoginRequest
import io.realworld.api.models.requests.SignupRequest
import io.realworld.api.models.responses.UserResponse

object UserRepo {

    val api = ConduitClient().publicApi

    val authAPI = ConduitClient().AuthApi

    suspend fun login(email: String, password: String): User? {
        val response = api.loginUser(LoginRequest(LoginData(email, password)))

        //TODO: save it in shared preferences

        ConduitClient().authToken = response.body()?.user?.token

        return response.body()?.user
    }

    suspend fun signup(username: String, email: String, password: String): User? {
        val response = api.signupUser(
            SignupRequest(
                SignupData(
                    email, password, username
                )
            )
        )

        //TODO: save it in shared preferences

        ConduitClient().authToken = response.body()?.user?.token

        return response.body()?.user

    }

    suspend fun getUserProfile() = authAPI.getCurrentUser().body()?.user
}
