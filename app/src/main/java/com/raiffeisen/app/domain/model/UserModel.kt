package com.raiffeisen.app.domain.model

data class UserModel(
    val name: String,
    val nationality: String,
    val age: Int,
    val pictureUrl: String,
    val registeredTime: String
)