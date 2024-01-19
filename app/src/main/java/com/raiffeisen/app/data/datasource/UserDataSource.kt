package com.raiffeisen.app.data.datasource

import com.raiffeisen.app.data.model.UserResponse
import retrofit2.http.GET

interface UserDataSource {

    @GET("?page=0&results=20&seed=abc")
    suspend fun getUsers(): List<UserResponse>
}