package com.raiffeisen.app.presentation.users

import com.raiffeisen.app.domain.model.UserModel
import kotlin.random.Random

object UserStateMapper {

    fun toUserState(user: UserModel): UserState {
       return UserState(
            hasAttachment = Random.nextBoolean(),
            username = user.name,
            userInfo = "${user.age} years old from ${user.nationality}",
            pictureUrl = user.pictureUrl,
            sentTime = user.registeredTime,
            isStar = Random.nextBoolean()
        )
    }
}