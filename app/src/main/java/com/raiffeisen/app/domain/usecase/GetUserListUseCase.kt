package com.raiffeisen.app.domain.usecase

import com.raiffeisen.app.domain.model.UserModel
import com.raiffeisen.app.util.Result

interface GetUserListUseCase {

    suspend fun getUserList(): Result<List<UserModel>>
}