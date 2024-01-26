package com.raiffeisen.app.domain.usecase

import com.raiffeisen.app.data.datasource.repository.UserRepository
import com.raiffeisen.app.domain.model.UserModel
import com.raiffeisen.app.domain.model.UserModelMapper
import com.raiffeisen.app.util.Result
import javax.inject.Inject

class GetUserListUseCaseImpl @Inject constructor(
    private val repository: UserRepository,
    private val mapper: UserModelMapper
) : GetUserListUseCase {

    override suspend fun getUserList(page: Int): Result<List<UserModel>> {
        val result = repository.getUsers(page)
        return if (result is Result.Success) {
            Result.Success(result.info?.results?.map { mapper.toUserModel(it) }.orEmpty())
        } else {
            Result.Error(result.error)
        }
    }

}