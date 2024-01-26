package com.raiffeisen.app.data.datasource.remote.api

import com.raiffeisen.app.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("?results=20&seed=abc")
    suspend fun getUsers(@Query("page") page: Int): UserResponse
}