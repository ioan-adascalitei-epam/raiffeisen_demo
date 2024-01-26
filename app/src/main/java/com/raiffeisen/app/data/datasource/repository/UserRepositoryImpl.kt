package com.raiffeisen.app.data.datasource.repository

import com.raiffeisen.app.data.datasource.UserDataSource
import com.raiffeisen.app.data.model.UserResponse
import com.raiffeisen.app.util.Result
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remote: UserDataSource
) : UserRepository {
    override suspend fun getUsers(page: Int): Result<UserResponse> = remote.getUsers(page)
}