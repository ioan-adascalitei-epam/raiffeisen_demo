package com.raiffeisen.app.data.datasource.remote

import com.raiffeisen.app.data.datasource.UserDataSource
import com.raiffeisen.app.data.datasource.remote.api.UserApi
import com.raiffeisen.app.data.model.UserResponse
import com.raiffeisen.app.util.Result
import javax.inject.Inject

class RemoteUserDataSource @Inject constructor(
    private val userApi: UserApi
): UserDataSource {
    override suspend fun getUsers(page: Int): Result<UserResponse> = apiCall { userApi.getUsers(page) }
}