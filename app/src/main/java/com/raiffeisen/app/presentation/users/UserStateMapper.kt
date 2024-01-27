package com.raiffeisen.app.presentation.users

import android.annotation.SuppressLint
import com.raiffeisen.app.domain.model.UserModel
import com.raiffeisen.app.util.extensions.toSimpleDate
import com.raiffeisen.app.util.extensions.toSimpleHourFormat
import java.text.SimpleDateFormat
import kotlin.random.Random

object UserStateMapper {

    fun toUserState(user: UserModel): UserState {
        return UserState(
            hasAttachment = Random.nextBoolean(),
            username = user.name,
            userInfo = "${user.age} years old from ${user.nationality}",
            pictureUrl = user.pictureUrl,
            sentTime = user.registeredTime.toSimpleDate()?.toSimpleHourFormat().orEmpty(),
            isStar = Random.nextBoolean()
        )
    }
}