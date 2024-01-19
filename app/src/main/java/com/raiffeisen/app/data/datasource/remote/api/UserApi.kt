package com.raiffeisen.app.data.datasource.remote.api

import com.raiffeisen.app.data.model.UserResponse
import retrofit2.http.GET

interface UserApi {

    @GET("?page=0&results=20&seed=abc")
    suspend fun getUsers(): UserResponse
}