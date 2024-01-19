package com.raiffeisen.app.domain.model

import com.raiffeisen.app.data.model.UserInfoResponse

object UserModelMapper {

    fun toUserModel(userResponse: UserInfoResponse) = UserModel(
        name = "${userResponse.name.first.orEmpty()} ${userResponse.name.last.orEmpty()}",
        nationality = userResponse.nat,
        age = userResponse.dob.age,
        pictureUrl = userResponse.picture.large.orEmpty(),
        registeredTime = userResponse.registered.date
    )
}