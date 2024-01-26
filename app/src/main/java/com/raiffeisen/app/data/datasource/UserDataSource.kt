package com.raiffeisen.app.data.datasource

import com.raiffeisen.app.data.model.UserResponse
import com.raiffeisen.app.util.Result


interface UserDataSource {

    suspend fun getUsers(page: Int): Result<UserResponse>
}