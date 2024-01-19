package com.raiffeisen.app.data.datasource.repository

import com.raiffeisen.app.data.model.UserResponse
import com.raiffeisen.app.util.Result

interface UserRepository {
    suspend fun getUsers(): Result<UserResponse>
}