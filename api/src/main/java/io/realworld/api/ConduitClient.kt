package io.realworld.api

import io.realworld.api.services.ConduitAPI
import io.realworld.api.services.ConduitAuthAPI
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ConduitClient {

    var authToken:String?=null

    private val authInterceptor= Interceptor{ chain ->
        var req=chain.request()
        authToken?.let {
            req=req.newBuilder().header("Authorization","Token $it").build()
        }
        chain.proceed(req)

    }

    val okHttpBuilder =OkHttpClient.Builder()
        .readTimeout(5,TimeUnit.SECONDS)
        .connectTimeout(2,TimeUnit.SECONDS)

    val retrofitBuilder=Retrofit.Builder()
        .baseUrl("https://api.realworld.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())


    val publicApi=retrofitBuilder
        .client(okHttpBuilder.build())
        .build()
        .create(ConduitAPI::class.java)

    val AuthApi=retrofitBuilder
        .client(okHttpBuilder.build())
        .build()
        .create(ConduitAuthAPI::class.java)

}